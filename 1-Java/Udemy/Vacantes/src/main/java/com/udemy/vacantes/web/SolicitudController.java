package com.udemy.vacantes.web;

import com.udemy.vacantes.dao.SolicitudDao;
import com.udemy.vacantes.dao.VacanteDao;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.udemy.vacantes.models.*;
import com.udemy.vacantes.utils.Utility;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/solicitudes")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 15,
        location = "/tmp"
)
public class SolicitudController extends HttpServlet {

    /*
    Directorio donde se guardaran los archivos fisicos.
    webapps/vacantesV2/uploads
     */
    private static final String UPLOAD_DIR = "uploads";

    /**
     * 1. Guardar un registro de una solicitud para una vacante
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        // Recibimos los campos de tipo texto
        String nombreParam = request.getParameter("nombre");
        String emailParam = request.getParameter("email");
        String telefonoParam = request.getParameter("telefono");
        String direccionParam = request.getParameter("direccion");
        Long idVacanteParam = Long.parseLong(request.getParameter("idVacante"));

        // Creamos el objeto que guardaremos
        Solicitud solicitud = new Solicitud(0L);
        solicitud.setFecha(new Date());
        solicitud.setNombre(nombreParam);
        solicitud.setEmail(emailParam);
        solicitud.setTelefono(telefonoParam);
        solicitud.setDireccion(direccionParam);
        VacanteDao vacanteDao = new VacanteDao();
        Vacante vacante = vacanteDao.getById(idVacanteParam);
        solicitud.setVacante(vacante);

        // gets absolute path of the web application
        String applicationPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        /*
        La clase Part, representa un archivo fisico que subio el usuario. Este nombre "archivo" debe ser el especificado
        en el formulario HTML para input de tipo file
            <input type="file" required id="archivo" name="archivo">
        */
        Part archivo = request.getPart("archivo");
        String archivoParam = archivo.getSubmittedFileName();
        RequestDispatcher rd;
        //Archivo valido, si lo guardamos
        String msg="";
        if (archivoParam.endsWith("pdf") || archivoParam.endsWith("doc") || archivoParam.endsWith("docx")) {

            /**
             * El nombre del archivo que guardaremos sera como sigue:
             *  1. Generamos una cadena de 10 caractereas aleatorios apoyandonos de la clase Utility.randomAlphaNumeric
             *  2. Posteriomente, al nombre del archivo "archivoParam", le hacemos un reemplazo de cualquier caracter de espacio
             *  por guiones. Suponiendo que el archivo que subio el usuario se llama "curriculum vitae.doc", con este procedimiento quedara
             *  por ejemplo   "O8PJYTTPJ7curriculum-vitae.doc"
             *  Ese sera el nombre del archiivo que guardaremos en la BD.
             *  Con esto nos aseguramos de que nunca se reemplazaran.
             */
            
            String archivoFisico = Utility.randomAlphaNumeric(10) + archivoParam.replace(" ", "_");
            // Asignamos el nombre del archivo que guadaremos en la bd
            solicitud.setArchivo(archivoFisico);

            SolicitudDao solicitudDao = new SolicitudDao();
            solicitudDao.insert(solicitud);
            msg = "<b>" + solicitud.getNombre() + "</b> hemos recibido tus datos."
                    + "<br> Revisaremos tu CV y nos comunicaremos contigo.<br><br>Gracias.";
            request.setAttribute("message", msg);
            
            // Escribimos el archivo al disco duro del servidor
            // Aqui se guarda el archivo al directorio webapps/vacantesV2/uploads con el nombre formado anteriormente
            archivo.write(uploadFilePath + File.separator + archivoFisico); 
            rd = request.getRequestDispatcher("/mensaje_guest.jsp");
            rd.forward(request, response);
        } else { // No es un archivo valido...
            
            msg = "Solo se permiten archivos de tipo PDF, DOC y DOCX";
            request.setAttribute("message", msg);
            /**
             * Si subio otro tipo de archivo, no lo permitimos.
             * Aqui lo que hacemos es compartir el JavaBean solicitud que en este punto ya esta completo con lo que capturo
             * el usuario. Aqui hacemos una redireccion a la vista frm_cv.jsp que es la vista donde el usuario captura su nombre, 
             * correo, direccion, telefono. Entonces como estamos regresando el Javabean solicitud a la vista, no tendra que capturar de nuevo su
             * nombre, correo, direccion, telefono, ya que al estar disponible este Javabean, mostramos los valores de cada propiedad en
             * cada input del formulario por ejemplo. <input type="text" class="form-control" name="nombre" value="${solicitud.nombre}" required id="nombre">
             * De esta forma el formulario quedara lleno con lo que habia capturado el usuario anteriomente y solo tendra que volver a subir otro archivo.
             */
            request.setAttribute("solicitud", solicitud);
            /**
             * Tambien regresamos a la vista frm_cv.jsp el Javabean vacante, porque lo ocupamos para indicar el valor de la idVacante para la cual 
             * esta aplicando el usuario. Esto lo hacemos en <input type="hidden" value="${vacante.id}" name="idVacante">
             */
            request.setAttribute("vacante", solicitud.getVacante());
            rd = request.getRequestDispatcher("/frm_cv.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        switch (action) {
            case "solicitudes":
                if (session.getAttribute("usuario") == null) {
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    this.verSolicitudes(request, response);
                }
                break;
            case "responder":
                if (session.getAttribute("usuario") == null) {
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    this.responder(request, response);
                }
                break;
        }
    }

    protected void verSolicitudes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd;
        String msg = null;
        List<Solicitud> lista = null;
        SolicitudDao solicitudDao = new SolicitudDao();
        lista = solicitudDao.getAll();

        request.setAttribute("mensaje", msg);
        request.setAttribute("solicitudes", lista);
        rd = request.getRequestDispatcher("/solicitudes.jsp");
        rd.forward(request, response);
    }

    protected void responder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        RequestDispatcher rd;
        request.setAttribute("email", email);
        // Hacemos un render del formulario para enviar el email
        rd = request.getRequestDispatcher("/email.jsp");
        rd.forward(request, response);
    }

}

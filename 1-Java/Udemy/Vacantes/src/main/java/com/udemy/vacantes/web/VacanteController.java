package com.udemy.vacantes.web;

import com.udemy.vacantes.dao.VacanteDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.udemy.vacantes.models.Vacante;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet("/vacantes")
public class VacanteController extends HttpServlet {

    private VacanteDao dao = new VacanteDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String detalle = req.getParameter("detalle");

        Vacante vacante = new Vacante(nombre, descripcion, detalle);

        System.out.println(vacante);

        vacante = dao.insert(vacante);
        String msg = vacante != null ? "La vacante fue guardada correctamente." : "Ocurrio un error. La vacante no fue guardada.";

        req.setAttribute("mensaje", msg);
        req.getRequestDispatcher("/mensaje.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "ver":
                verDetalle(req, resp);
                break;
            case "all":
                verTodos(req, resp);
                break;
            case "delete":
                borrarVacante(req, resp);
                break;
            case "enviarCV":
                mostrarFormularioCV(req, resp);
                break;
            default:

        }
    }

    private void verDetalle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("idVacante"));
        Vacante vacante = dao.getById(id);

        req.setAttribute("vacante", vacante);
        req.getRequestDispatcher("detalle.jsp").forward(req, resp);
    }

    private void verTodos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Vacante> vacantes = dao.getAll();

        req.setAttribute("vacantes", vacantes);
        req.getRequestDispatcher("vacantes.jsp").forward(req, resp);
    }

    private void borrarVacante(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("idVacante"));
        boolean result = dao.delete(id);

        String mensaje = result ? "Vacante borrado exitosamente" : "No se pudo borrar la vacante.";
        req.setAttribute("mensaje", mensaje);

        verTodos(req, resp);
    }
    
    private void mostrarFormularioCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Long idVacante = Long.parseLong(request.getParameter("id"));      
        Vacante vacante = null;
        vacante = dao.getById(idVacante);    
        request.setAttribute("vacante", vacante);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/frm_cv.jsp");
        rd.forward(request, response);
    }
}

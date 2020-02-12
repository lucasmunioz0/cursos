package web.seccion66.leccion211;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/leccion211/manejoSesiones")
public class ManejoSesionesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        
        final HttpSession session = request.getSession();
        String titulo = null;
        
        //Pedir atributo contadorVisitas a la sesión
        Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez.";
        }else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        session.setAttribute("contadorVisitas", contadorVisitas);
        try(PrintWriter pw = response.getWriter()){
            pw.println("<h1>" + titulo + "</h1>");
            pw.println("N° de accesos al recurso: " + contadorVisitas);
            pw.println("<br/>");
            pw.println("ID de la sesión: " + session.getId());
        }
    }
}
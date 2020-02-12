package web.seccion60.leccion194;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion194/manejoParametros")
public class ManejoDeParametros extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String usuario = req.getParameter("usuario");
        final String password = req.getParameter("password");
        
        System.out.println("Usuario: " + usuario);
        System.out.println("Password: " + password);
        
        resp.setContentType("text/html;charset=utf-8");
        try(PrintWriter writer = resp.getWriter()){
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h1>Datos ingresados</h1>");
            writer.println("<p>Usuario: " + usuario);
            writer.println("</p>");
            writer.println("<p>Password:" + password);
            writer.println("</p>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }
    
}

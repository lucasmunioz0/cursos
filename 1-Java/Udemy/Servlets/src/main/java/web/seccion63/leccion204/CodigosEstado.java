package web.seccion63.leccion204;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion204/codigos")
public class CodigosEstado extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String usuarioOk = "Pepe";
        final String passwordOk = "123";
        final String usuario = request.getParameter("usuario");
        final String password = request.getParameter("password");

        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter pw = response.getWriter()) {
            if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
                pw.println("<h1>Datos correctos</h1>");
                pw.println("<p><b>Usuario:</b>" + usuario + "</p>");
                pw.println("<p><b>Password:</b>" + password + "</p>");
            }else{
                response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas.");
            }
        }
    }
}

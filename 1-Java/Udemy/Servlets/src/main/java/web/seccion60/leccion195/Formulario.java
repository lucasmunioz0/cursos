package web.seccion60.leccion195;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion195/formulario")
public class Formulario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        String[] tecnologias = req.getParameterValues("tecnologia");
        String genero = req.getParameter("genero");
        String ocupacion = req.getParameter("ocupacion");
        String[] musicas = req.getParameterValues("musica");
        String comentario = req.getParameter("comentarios");

        resp.setContentType("text/html;charset=utf-8");
        try (PrintWriter pw = resp.getWriter()) {
            pw.println("<html>");
            pw.println("<body>");
            pw.println("<table border=\"1\">");
            pw.println("<tr><td>Usuario</td><td>");
            pw.println(usuario);
            pw.println("</td></tr>");
            pw.println("<tr><td>Password</td><td>");
            pw.println(password);
            pw.println("</td></tr>");
            pw.println("<tr><td>Tecnologías de interés</td><td>");
            Stream.of(tecnologias).forEach(t -> pw.println(t));
            pw.println("</td></tr>");
            pw.println("<tr><td>Género</td>");
            pw.println("<td>" + genero + "</td>");
            pw.println("</tr>");
            pw.println("<tr><td>Ocupación</td>");
            pw.println("<td>" + ocupacion + "</td>");
            pw.println("</tr>");
            pw.println("<tr><td>Música favorita</td><td>");
            if (musicas != null) {
                Stream.of(musicas).forEach(m -> pw.println(m));
            } else {
                pw.println("Valor no proporcionado");
            }
            pw.println("</td></tr>");
            pw.println("<tr><td>Comentario</td><td>");
            if (comentario != null) {
                pw.println(comentario);
            } else {
                pw.println("Escribe un comentario");
            }
            pw.println("</td></tr>");
            pw.println("</table>");
            pw.println("</body>");
            pw.println("</html>");
        }
    }
}

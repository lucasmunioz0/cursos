package web.seccion65.leccion208;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion208/cookies")
public class ManejoCookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Suponemos que el usuario visita por primera vez nuestro sitio
        boolean nuevoUsuario = true;
        final Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitanteRecurrente") && cookie.getValue().equals("Si")) {
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        String mensaje;
        if (nuevoUsuario) {
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "Si");
            visitanteCookie.setMaxAge(20);
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        }else{
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio.";
        }
        
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter pw = response.getWriter()){
            pw.println(mensaje);
        }
    }
}

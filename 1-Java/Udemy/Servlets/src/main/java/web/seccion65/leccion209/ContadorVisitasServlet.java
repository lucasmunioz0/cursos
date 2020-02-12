package web.seccion65.leccion209;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion209/contador")
public class ContadorVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        int contador = 0;
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(cookie.getValue());                    
                }
            }
        }
        
        contador++;
        Cookie respuesta = new Cookie("contadorVisitas", String.valueOf(contador));
        
        respuesta.setMaxAge(3600);
        response.addCookie(respuesta);
        
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter pw = response.getWriter()){
            pw.println("Contador de visitas de cada cliente: " + contador);
        }
    }    
}
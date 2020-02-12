package web.seccion62.leccion202;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion202/cabeceras")
public class CabecerasHttp extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
        reponse.setContentType("text/html;charset=utf-8");
        
        try(PrintWriter pw = reponse.getWriter()){
            pw.println("<html>");
            pw.println("<body>");
            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String header = headerNames.nextElement();
                pw.println("<p><b>" + header + "</b>: " + request.getHeader(header) + "</p>");
            }
            //En caso de utilizar el headers del response...
//            headerNames.(header -> {
//                pw.println("<p><bold>" + header + "</bold>: " + req.getHeader(header) + "</p>");
//            });
            pw.println("Método Http: " + request.getMethod());
            pw.println("</br>");
            pw.println("URI: " + request.getRequestURI());
            pw.println("</body>");
            pw.println("</html>");
        }
    }    
}
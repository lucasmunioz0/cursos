package web.seccion64.leccion206;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion206/hora")
public class HoraServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("refresh", "1");
        final Date fecha = new Date();
        final SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada:' HH:mm:ss");
        final String fechaFormateada = formateador.format(fecha);
        
        try(PrintWriter pw = response.getWriter()){
            pw.println("<h1>" + fechaFormateada + "</h1>");
        }
    }    
}
package web.seccion66.leccion212;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/leccion212/carritoCompras")
public class CarritoComprasServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        final String articulo = request.getParameter("articulo");
        final HttpSession session = request.getSession();
        final List<String> articulos = (List<String>) session.getAttribute("articulos") != null
                ? (List<String>) session.getAttribute("articulos")
                : new ArrayList<>();
        
        session.setAttribute("articulos", articulos);
        
        if (articulo != null && !articulo.trim().isEmpty() && !articulos.contains(articulo)) {
            articulos.add(articulo);
        }
        
        try(PrintWriter pw = response.getWriter()){
            pw.println("<h1>Listado de Artículos</h1>");
            pw.println("<br/>");
            pw.println("<ul>");
            articulos.forEach(a -> {
                pw.println("<li>" + a + "</li>");
            });
            pw.println("</ul>");
            pw.println("<br/>");
            pw.println("<a href='/Servlets/leccion212'>Regresar al inicio</a>");
        }
    }
}
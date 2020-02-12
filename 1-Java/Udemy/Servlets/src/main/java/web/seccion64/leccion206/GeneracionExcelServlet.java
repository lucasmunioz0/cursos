package web.seccion64.leccion206;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/leccion206/excel")
public class GeneracionExcelServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Indicamos el tipo de respuesta
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        
        //Indicamos que no guarde cache
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);
        
        //Desplegamos la información
        try(PrintWriter pw = response.getWriter()){
            pw.println("\tValores");
            pw.println("\t1");
            pw.println("\t2");
            pw.println("Total\t=SUMA(b2:b3)");
        }
    }    
}
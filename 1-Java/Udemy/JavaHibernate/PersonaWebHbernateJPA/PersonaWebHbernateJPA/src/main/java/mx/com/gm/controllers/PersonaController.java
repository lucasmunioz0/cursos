package mx.com.gm.controllers;

import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.domain.Persona;
import mx.com.gm.services.ServicioPersonas;

@WebServlet("/personas")
public class PersonaController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ServicioPersonas servicio = new ServicioPersonas();
        List<Persona> personas = servicio.getAll();
        
        req.setAttribute("personas", personas);
        try{
            req.getRequestDispatcher("/WEB-INF/listado.jsp").forward(req, resp);
        }catch(Exception e){ 
            e.printStackTrace(System.out);
        }
        
    }
}

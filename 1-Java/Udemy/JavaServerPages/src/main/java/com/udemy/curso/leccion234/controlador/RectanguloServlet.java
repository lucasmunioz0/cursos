package com.udemy.curso.leccion234.controlador;

import com.udemy.curso.leccion234.modelo.Rectangulo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/JavaServerPages/leccion234/rectangulo", "/leccion234/rectangulo"})
public class RectanguloServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. Procesamos parámetros
        final String accion = request.getParameter("accion");
        
        //2. Creamos los JavaBeans
        final Rectangulo rectanguloRequest = new Rectangulo(1, 2);
        final Rectangulo rectanguloSession = new Rectangulo(3, 4);
        final Rectangulo rectanguloAplicacion = new Rectangulo(5, 6);
        
        //3. Agregamos el JavaBean a algún alcance
        
        //Revisamos la acción
        if("agregaVariables".equals(accion)){
            //Alcance de request
            request.setAttribute("rectanguloRequest", rectanguloRequest);
            //Alcance de session
            request.getSession().setAttribute("rectanguloSession", rectanguloSession);
            //Alcande de aplicacion
            this.getServletContext().setAttribute("rectanguloAplicacion", rectanguloAplicacion);
            
            //Agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //4. Redireccionamos a JSP que despliega las variables
            request.getRequestDispatcher("leccion234/").forward(request, response);
        }else if("listarVariables".equals(accion)){
            //4. Redireccionamos a JSP que despliega las variables
            request.getRequestDispatcher("/WEB-INF/leccion234/alcanceVariables.jsp").forward(request, response);
        }else{
            //4. Redireccionamos a la página de inicio
            request.setAttribute("mensaje", "Acción no proporcionada o desconocida");
            request.getRequestDispatcher("leccion234/").forward(request, response);
        }
    }
}
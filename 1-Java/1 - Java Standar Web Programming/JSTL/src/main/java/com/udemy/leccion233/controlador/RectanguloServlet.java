package com.udemy.leccion233.controlador;

import com.udemy.leccion233.modelo.Rectangulo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/rectangulo")
public class RectanguloServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1. Procesamos parámetros
        
        //2. Creamos los JavaBeans
        final Rectangulo rectangulo = new Rectangulo(3, 6);
        
        //3. Agregamos el JavaBean a algún alcance
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        final HttpSession session = request.getSession();
        session.setAttribute("rectangulo", rectangulo);
        
        //4. Redireccionar a la vista seleccionada
        final RequestDispatcher requestDispatcher = request.getRequestDispatcher("leccion233/vista/desplegarVariables.jsp");
        requestDispatcher.forward(request, response);
    }
}
package com.udemy.javaee.sga.controller;

import com.udemy.javaee.sga.domain.Persona;
import com.udemy.javaee.sga.service.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/personas/listar")
public class PersonaController extends HttpServlet{
    
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final List<Persona> persons = personaService.getAll();
        System.out.println("personas " + persons);
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}

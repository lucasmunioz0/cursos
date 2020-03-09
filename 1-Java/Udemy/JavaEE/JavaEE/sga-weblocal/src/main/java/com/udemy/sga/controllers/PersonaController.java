package com.udemy.sga.controllers;

import com.udemy.sga.domain.Persona;
import com.udemy.sga.services.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personas/listar")
public class PersonaController extends HttpServlet{
    
    @Inject
    private PersonaService service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final List<Persona> persons = service.findAll();
        System.out.println("personas " + persons);
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}

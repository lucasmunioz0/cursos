package com.udemy.sga.controllers;

import com.udemy.sga.domain.Usuario;
import com.udemy.sga.services.UsuarioService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuarios/listar")
public class UsuarioController extends HttpServlet{
    
    @Inject
    private UsuarioService service;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final List<Usuario> users = service.findAll();
        System.out.println("usuarios " + users);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
    }
}

package com.udemy.vacantes.web;

import com.udemy.vacantes.dao.VacanteDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.udemy.vacantes.models.Vacante;

@WebServlet("/homepage")
public class IndexController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VacanteDao dao = new VacanteDao();
        List<Vacante> vacantes = dao.getUltimas();
        
        req.setAttribute("vacantes", vacantes);
        
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    
    
}

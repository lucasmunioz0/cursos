package com.udemy.vacantes.web;

import com.udemy.vacantes.dao.VacanteDao;
import com.udemy.vacantes.models.Vacante;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscar")
public class BuscadorController extends HttpServlet{
    private VacanteDao dao = new VacanteDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        List<Vacante> vacantes = dao.getByQuery(query);

        req.setAttribute("vacantes", vacantes);
        req.getRequestDispatcher("vacantes.jsp").forward(req, resp);
    }
    
}

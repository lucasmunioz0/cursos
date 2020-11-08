package com.udemy.vacantes.web;

import com.udemy.vacantes.dao.UsuarioDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.udemy.vacantes.models.Usuario;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UsuarioDao dao = new UsuarioDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String user = req.getParameter("usuario");
        String password = req.getParameter("password");
        String msg = "";
        HttpSession session = req.getSession();

        Usuario usuario = dao.login(user, password);

        if (usuario != null) {
            session.setAttribute("usuario", usuario);
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        } else {
            msg = "Usuario y/o contraseña incorrectos";
            req.setAttribute("mensaje", msg);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String msg = "";

        switch (action) {
            case "login":
                if (req.getSession().getAttribute("usuario") == null) {
                    req.setAttribute("mensaje", "Debe iniciar sesión.");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/admin.jsp").forward(req, resp);
                }
                break;
            case "logout":
                req.getSession().invalidate();
                resp.sendRedirect(req.getContextPath() + "/homepage");
                break;
            case "crear":
                if (req.getSession().getAttribute("usuario") == null) {
                    req.setAttribute("mensaje", "Debe iniciar sesión.");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/frmVacante.jsp").forward(req, resp);
                }
                break;
        }
    }
}

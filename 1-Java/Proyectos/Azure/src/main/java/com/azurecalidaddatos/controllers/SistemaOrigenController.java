package com.azurecalidaddatos.controllers;

import com.azurecalidaddatos.daos.DaoSistemaOrigen;
import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.SistemaOrigen;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SistemasOrigen", urlPatterns = {"/sistemaOrigen"})
public class SistemaOrigenController extends HttpServlet {

    private static final DaoSistemaOrigen dao = new DaoSistemaOrigen();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "GetAll":
                doGetAll(request, response);
                break;
            case "Agregar": case "Actualizar":
                doPost(request, response);
                break;
            case "Ver":
                doGet(request, response);
                break;
            case "Borrar":
                doDelete(request, response);
                break;
            case "Filtrar":
                doFiltrar(request, response);
                break;
            default:
                doGetAll(request, response);
        }
    }

    private void doGetAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<SistemaOrigen> sistemas = dao.getAll();
            request.getSession().setAttribute("sistemasOrigen", sistemas);
        } catch (SQLException ex) {
            request.getSession().setAttribute("error", ex.toString());
        } finally {
            response.sendRedirect("calidadDatos/sistemasOrigen.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SistemaOrigen sistema = null;
        String mensaje = "";
        try {
            final String nombre = request.getParameter("nombre").trim();
            final String idStr = request.getParameter("id");
            final BigDecimal id = idStr != null && !idStr.isEmpty() ? new BigDecimal(idStr) : new BigDecimal(0);
            sistema = new SistemaOrigen(id, nombre);
            mensaje = insertOrUpdate(sistema);
            request.getSession().setAttribute("msg", mensaje + " con éxito");
            doGetAll(request, response);
        } catch (NumberFormatException | SQLException | BusinessException ex ) {
            request.getSession().setAttribute("msg", ex.toString());
            if (request.getParameter("action").equals("Actualizar")) {
                request.getSession().setAttribute("sistemaOrigen", sistema);
                response.sendRedirect("calidadDatos/editarSistemaOrigen.jsp");
            } else {
                response.sendRedirect("calidadDatos/agregarSistemaOrigen.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final BigDecimal id = request.getParameter("id") != null && request.getParameter("id").trim().length() > 0
                    ? new BigDecimal(request.getParameter("id")) : new BigDecimal(0);
            final SistemaOrigen sistema = dao.getById(new SistemaOrigen(id));
            request.getSession().setAttribute("sistemaOrigen", sistema);
            response.sendRedirect("calidadDatos/editarSistemaOrigen.jsp");
        } catch (NumberFormatException | SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
            doGetAll(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final BigDecimal id = request.getParameter("id") != null && request.getParameter("id").trim().length() > 0
                    ? new BigDecimal(request.getParameter("id")) : new BigDecimal(0);
            final SistemaOrigen sistema = new SistemaOrigen(id);
            dao.delete(sistema);
            request.getSession().setAttribute("msg", "Eliminación con éxito");
        } catch (NumberFormatException | SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        } finally {
            doGetAll(request, response);
        }
    }

    private String insertOrUpdate(SistemaOrigen sistema) throws SQLException, BusinessException {
        String mensaje = "Inserción";
        if (sistema.getId() != null && sistema.getId().compareTo(new BigDecimal(0)) != 0) {
            dao.update(sistema);
            mensaje = "Actualización";
        } else {
            dao.insert(sistema);
        }

        return mensaje;
    }

    private void doFiltrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String idStr = request.getParameter("id");
        final String nombre = request.getParameter("nombre").trim();
        
        try {
            BigDecimal id  = idStr != null && !idStr.equals("")? new BigDecimal(idStr) : null;
            if(id != null){
                doGet(request, response);
                return;
            }
            List<SistemaOrigen> sistemas = dao.getObjectsByNombre(nombre);
            request.getSession().setAttribute("sistemasOrigen", sistemas);
        } catch (SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        }
        response.sendRedirect("calidadDatos/sistemasOrigen.jsp");
    }
}

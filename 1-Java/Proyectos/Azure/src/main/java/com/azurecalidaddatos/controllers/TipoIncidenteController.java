package com.azurecalidaddatos.controllers;

import com.azurecalidaddatos.daos.DaoTipoIncidente;
import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.TipoIncidente;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TiposIncidentes", urlPatterns = {"/tipoIncidente"})
public class TipoIncidenteController extends HttpServlet {

    private static final DaoTipoIncidente dao = new DaoTipoIncidente();

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
            List<TipoIncidente> tiposIncidentes = dao.getAll();
            request.getSession().setAttribute("tiposIncidente", tiposIncidentes);
        } catch (SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        } finally {
            response.sendRedirect("calidadDatos/tiposIncidente.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoIncidente tipoIncidente = null;
        String mensaje = "";
        try {
            final String nombre = request.getParameter("nombre").trim();
            final String idStr = request.getParameter("id");
            final BigDecimal id = idStr != null && !idStr.isEmpty() ? new BigDecimal(idStr) : new BigDecimal(0);
            tipoIncidente = new TipoIncidente(id, nombre);
            mensaje = insertOrUpdate(tipoIncidente);
            request.getSession().setAttribute("msg", mensaje + " con éxito");
            doGetAll(request, response);
        } catch (NumberFormatException | SQLException | BusinessException ex ) {
            request.getSession().setAttribute("msg", ex.toString());
            if (request.getParameter("action").equals("Actualizar")) {
                request.getSession().setAttribute("tipoIncidente", tipoIncidente);
                response.sendRedirect("calidadDatos/editarTipoIncidente.jsp");
            } else {
                response.sendRedirect("calidadDatos/agregarTipoIncidente.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final BigDecimal id = request.getParameter("id") != null && request.getParameter("id").trim().length() > 0
                    ? new BigDecimal(request.getParameter("id")) : new BigDecimal(0);
            final TipoIncidente tipoIncidente = dao.getById(new TipoIncidente(id));
            request.getSession().setAttribute("tipoIncidente", tipoIncidente);
            response.sendRedirect("calidadDatos/editarTipoIncidente.jsp");
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
            final TipoIncidente tipoIncidente = new TipoIncidente(id);
            dao.delete(tipoIncidente);
            request.getSession().setAttribute("msg", "Eliminación con éxito");
        } catch (NumberFormatException | SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        } finally {
            doGetAll(request, response);
        }
    }

    private String insertOrUpdate(TipoIncidente tipoIncidente) throws SQLException, BusinessException {
        String mensaje = "Inserción";
        if (tipoIncidente.getId() != null && tipoIncidente.getId().compareTo(new BigDecimal(0)) != 0) {
            dao.update(tipoIncidente);
            mensaje = "Actualización";
        } else {
            dao.insert(tipoIncidente);
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
            List<TipoIncidente> tiposIncidente = dao.getObjectsByNombre(nombre);
            request.getSession().setAttribute("tiposIncidente", tiposIncidente);
        } catch (SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        }
        response.sendRedirect("calidadDatos/tiposIncidente.jsp");
    }
}

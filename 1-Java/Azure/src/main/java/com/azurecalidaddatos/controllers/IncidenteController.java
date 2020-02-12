package com.azurecalidaddatos.controllers;

import com.azurecalidaddatos.business.IncidenteBus;
import com.azurecalidaddatos.daos.DaoEstadoIncidente;
import com.azurecalidaddatos.daos.DaoIncidente;
import com.azurecalidaddatos.daos.DaoObjetoSistema;
import com.azurecalidaddatos.daos.DaoSistemaOrigen;
import com.azurecalidaddatos.daos.DaoSucesoIncidente;
import com.azurecalidaddatos.daos.DaoTipoIncidente;
import com.azurecalidaddatos.daos.IDao;
import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Incidentes", urlPatterns = {"/incidente"})
public class IncidenteController extends HttpServlet {

    private static final IDao<Incidente> daoIncidente = new DaoIncidente();
    private static final IDao<SistemaOrigen> daoSistemaOrigen = new DaoSistemaOrigen();
    private static final IDao<TipoIncidente> daoTipoIncidente = new DaoTipoIncidente();
    private static final IDao<EstadoIncidente> daoEstadoIncidente = new DaoEstadoIncidente();
    private static final IDao<SucesoIncidente> daoSucesoIncidente = new DaoSucesoIncidente();
    private static final IDao<ObjetoSistema> daoObjetoSistema = new DaoObjetoSistema();
    private static final IncidenteBus incidenteBus = new IncidenteBus();

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
            case "New":
                doNew(request, response);
                break;
            default:
                doGetAll(request, response);
        }
    }

    private void doGetAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Incidente> incidentes = daoIncidente.getAll();
            request.getSession().setAttribute("incidentes", incidentes);
        } catch (SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        } finally {
            response.sendRedirect("calidadDatos/incidentes.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacIncidente incidente = null;
        String mensaje;
        try {
            incidente = obtenerDatos(request);
            mensaje = incidenteBus.insertarIncidente(incidente).toString();
            request.getSession().setAttribute("msg", mensaje + " con éxito");
            doGetAll(request, response);
        } catch (NumberFormatException | SQLException ex ) {
            request.getSession().setAttribute("msg", ex.toString());
            if (request.getParameter("action").equals("Actualizar")) {
                request.getSession().setAttribute("incidente", incidente);
                response.sendRedirect("calidadDatos/editarIncidente.jsp");
            } else {
                response.sendRedirect("calidadDatos/registrarIncidente.jsp");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final BigDecimal id = request.getParameter("id") != null && request.getParameter("id").trim().length() > 0
                    ? new BigDecimal(request.getParameter("id")) : new BigDecimal(0);
            final Incidente incidente = daoIncidente.getById(new Incidente(id));
            request.getSession().setAttribute("incidente", incidente);
            response.sendRedirect("calidadDatos/editarIncidente.jsp");
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
            final Incidente incidente = new Incidente(id);
            daoIncidente.delete(incidente);
            request.getSession().setAttribute("msg", "Eliminación con éxito");
        } catch (NumberFormatException | SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        } finally {
            doGetAll(request, response);
        }
    }

    private String insertOrUpdate(Incidente incidente) throws SQLException, BusinessException {
        String mensaje = "Inserción";
        if (incidente.getId() != null && incidente.getId().compareTo(new BigDecimal(0)) != 0) {
            daoIncidente.update(incidente);
            mensaje = "Actualización";
        } else {
            daoIncidente.insert(incidente);
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
            List<Incidente> incidentes = daoIncidente.getObjectsByNombre(nombre);
            request.getSession().setAttribute("incidentes", incidentes);
        } catch (SQLException | BusinessException ex) {
            request.getSession().setAttribute("msg", ex.toString());
        }
        response.sendRedirect("calidadDatos/incidentes.jsp");
    }

    private void doNew(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<SistemaOrigen> sistemasOrigen = daoSistemaOrigen.getAll();
            List<TipoIncidente> tiposIncidente = daoTipoIncidente.getAll();
            List<EstadoIncidente> estadosIncidente = daoEstadoIncidente.getAll();
            List<SucesoIncidente> sucesosIncidente = daoSucesoIncidente.getAll();
            List<ObjetoSistema> objetosSistema = daoObjetoSistema.getAll();
            request.getSession().setAttribute("sistemasOrigen", sistemasOrigen);
            request.getSession().setAttribute("tiposIncidente", tiposIncidente);
            request.getSession().setAttribute("estadosIncidente", estadosIncidente);
            request.getSession().setAttribute("sucesosIncidente", sucesosIncidente);
            request.getSession().setAttribute("objetosSistema", objetosSistema);
            response.sendRedirect("calidadDatos/registrarIncidente.jsp");
        } catch (SQLException | BusinessException ex) {
            request.getSession().setAttribute("error", ex.toString());
            response.sendRedirect("calidadDatos/incidentes.jsp");
        }        
    }

    private FacIncidente obtenerDatos(HttpServletRequest request) {
        final String idStrIncidente = request.getParameter("id") != null && !request.getParameter("id").isEmpty()? request.getParameter("id") : "0";
        final String idStrSistemOrigen = request.getParameter("sistemaOrigen") != null? request.getParameter("sistemaOrigen") : "0";
        final String idStrTipoIncidente = request.getParameter("tipoIncidente") != null? request.getParameter("tipoIncidente") : "0";
        final String idStrEstadoIncidente = request.getParameter("estadoIncidente") != null? request.getParameter("estadoIncidente") : "0";
        final String idStrSucesoIncidente = request.getParameter("sucesoIncidente") != null? request.getParameter("sucesoIncidente") : "0";
        final String idStrObjetoSistema = request.getParameter("objetoSistema") != null? request.getParameter("objetoSistema") : "0";
        final String incidente = request.getParameter("incidente");
        final String descripcion = request.getParameter("descripcion");
        final String causa = request.getParameter("causa");
        final String mitigación = request.getParameter("mitigacion");
        final String ticketDerivado = request.getParameter("ticketDerivado");
        final String informador = request.getParameter("informador");
        
        final BigDecimal idIncidente = new BigDecimal(idStrIncidente);
        final BigDecimal idSistemaOrigen = new BigDecimal(idStrSistemOrigen);
        final BigDecimal idTipoIncidente = new BigDecimal(idStrTipoIncidente);
        final BigDecimal idEstadoIncidente = new BigDecimal(idStrEstadoIncidente);
        final BigDecimal idSucesoIncidente = new BigDecimal(idStrSucesoIncidente);
        final BigDecimal idObjetoSistema = new BigDecimal(idStrObjetoSistema);
        
        final FacIncidente facIncidente = new FacIncidente(new CausaIncidente(causa), new DescripcionIncidente(descripcion), new EstadoIncidente(idEstadoIncidente), new Incidente(idIncidente, incidente),
                new Informador(informador), new MitigacionIncidente(mitigación), new ObjetoSistema(idObjetoSistema), new SistemaOrigen(idSistemaOrigen), new SucesoIncidente(idSucesoIncidente), new TicketDerivado(ticketDerivado)
                , new TipoIncidente(idTipoIncidente), 0, LocalDate.now());
        
        return facIncidente;
    }

    private void doPrueba(HttpServletRequest request, HttpServletResponse response) {
        FacIncidente fac = obtenerDatos(request);
        
        System.out.println("Cantidad: " + fac.getCantidad());
        System.out.println("Id Incidente: " + fac.getIncidente().getId());
        System.out.println("Id Sistema de Origen: " + fac.getIncidente().getId());
        System.out.println("Id Tipo de Incidente: " + fac.getIncidente().getId());
        System.out.println("Id Estado de Incidente: " + fac.getIncidente().getId());
        System.out.println("Id Suceso Incidente: " + fac.getSucesoIncidente().getId());
        System.out.println("Id Objeto Sistema: " + fac.getObjetoSistema().getId());
        System.out.println("Incidente: " + fac.getIncidente().getNombre());
        System.out.println("Descripcion: " + fac.getDescripcionIncidente().getNombre());
        System.out.println("Causa: " + fac.getCausaIncidente().getNombre());
        System.out.println("Mitigacion: " + fac.getMitigacionIncidente().getNombre());
        System.out.println("Ticket derivado: " + fac.getTicketDerivado().getNombre());
        System.out.println("Informador: " + fac.getInformador().getNombre());
        System.out.println("Fecha: " + fac.getFechaIncidente());
    }
}

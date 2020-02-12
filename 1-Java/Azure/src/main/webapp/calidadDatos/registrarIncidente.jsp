<%@page import="java.util.ArrayList"%>
<%@page import="com.azurecalidaddatos.models.SistemaOrigen"%>
<%@page import="com.azurecalidaddatos.models.TipoIncidente"%>
<%@page import="com.azurecalidaddatos.models.EstadoIncidente"%>
<%@page import="com.azurecalidaddatos.models.SucesoIncidente"%>
<%@page import="com.azurecalidaddatos.models.ObjetoSistema"%>
<%@page import="com.azurecalidaddatos.models.ModeloBase"%>
<%@page import="java.util.List"%>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incidentes</title>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <%
            String mensaje = String.valueOf(request.getSession().getAttribute("msg"));
            List<SistemaOrigen> sistemasOrigen = (List<SistemaOrigen>) request.getSession().getAttribute("sistemasOrigen");
            List<TipoIncidente> tiposIncidente = (List<TipoIncidente>) request.getSession().getAttribute("tiposIncidente");
            List<EstadoIncidente> estadosIncidentes = (List<EstadoIncidente>) request.getSession().getAttribute("estadosIncidente");
            List<SucesoIncidente> sucesosIncidentes = (List<SucesoIncidente>) request.getSession().getAttribute("sucesosIncidente");
            List<ObjetoSistema> objetosSistema = (List<ObjetoSistema>) request.getSession().getAttribute("objetosSistema");
            if (sistemasOrigen == null) {
                sistemasOrigen = new ArrayList<SistemaOrigen>();
            }
            if (tiposIncidente == null) {
                tiposIncidente = new ArrayList<TipoIncidente>();
            }
            if (estadosIncidentes == null) {
                estadosIncidentes = new ArrayList<EstadoIncidente>();
            }
            if (sucesosIncidentes == null) {
                sucesosIncidentes = new ArrayList<SucesoIncidente>();
            }
            if (objetosSistema == null) {
                objetosSistema = new ArrayList<ObjetoSistema>();
            }
        %>

        <header>
            <%@include file="topBanner.jsp"%>
        </header>
        <div>
            <table style="width: 100%">
                <th style="text-align: left">
                    <h1>Registrar Incidente</h1>
                </th>
                <th style="text-align: right; padding-right: 10px">
                    Volver<a href="../incidente?action=GetAll"><img src="../imagenes/iconos/volver.png" width="25" height="25" alt="Volver"/></a>
                </th>
            </table>
        </div>
        <fieldset class="wrapper">
            <legend>Agregar nuevo Incidente</legend>             
            <%
                if (mensaje != null && !mensaje.equals("null")) {
                    out.print("<div class=\"error\"><p>" + mensaje + "</p></div>");
                }
            %>
            <br/>
            <fieldset>
                <form method="post" action="../incidente">
                    <table>
                        <tr>
                            <td class="firstColumn">Id:</td>
                            <td><input type="number" name="id"/></td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Sistema de Origen:</td>
                            <td>
                                <select name="sistemaOrigen">
                                    <%
                                       for (SistemaOrigen sistemaOrigen : sistemasOrigen) {
                                               out.print("<option value=\""+sistemaOrigen.getId()+"\">" + sistemaOrigen.getNombre()+"</option>");
                                           }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Tipo:</td>
                            <td>
                                <select name="tipoIncidente">
                                    <%
                                       for (TipoIncidente tipoIncidente : tiposIncidente) {
                                               out.print("<option value=\""+tipoIncidente.getId()+"\">" + tipoIncidente.getNombre()+"</option>");
                                           }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Estado:</td>
                            <td>
                                <select name="estadoIncidente">
                                    <%
                                       for (EstadoIncidente estadoIncidente : estadosIncidentes) {
                                               out.print("<option value=\""+estadoIncidente.getId()+"\">" + estadoIncidente.getNombre()+"</option>");
                                           }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Suceso:</td>
                            <td>
                                <select name="sucesoIncidente">
                                    <%
                                       for (SucesoIncidente sucesoIncidente : sucesosIncidentes) {
                                               out.print("<option value=\""+sucesoIncidente.getId()+"\">" + sucesoIncidente.getNombre()+"</option>");
                                           }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Objeto de Sistema</td>
                            <td>
                                <select name="objetoSistema">
                                    <%
                                       for (ObjetoSistema objetoSistema : objetosSistema) {
                                               out.print("<option value=\""+objetoSistema.getId()+"\">" + objetoSistema.getNombre()+"</option>");
                                           }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Incidente:</td>
                            <td>
                                <textarea name="incidente" cols="150" rows="2"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Descripción:</td>
                            <td>
                                <textarea name="descripcion" cols="150" rows="10"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Causa:</td>
                            <td>
                                <textarea name="causa" cols="150" rows="10"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Mitigación:</td>
                            <td>
                                <textarea name="mitigacion" cols="150" rows="10"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Ticket derivado:</td>
                            <td>
                                <input type="text" name="ticketDerivado" />
                            </td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Informador:</td>
                            <td>
                                <input type="text" name="informador" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" name="action" value="Agregar"/>
                                <input type="reset" name="action" value="Limpiar"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </fieldset>
    </body>
</html>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.azurecalidaddatos.models.SistemaOrigen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistemas de Origen</title>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <%
            String mensaje = String.valueOf(request.getSession().getAttribute("msg"));
            List<SistemaOrigen> sistemas = (List<SistemaOrigen>) request.getSession().getAttribute("sistemasOrigen");
        
            if (sistemas == null) {
                sistemas = new ArrayList<SistemaOrigen>();
            }
        %>
        <header>
            <%@include file="topBanner.jsp" %>
        </header>
        <div>
            <table style="width: 100%">
                <th style="text-align: left">
                    <h1>Sistemas de Origen</h1>
                </th>
                <th style="text-align: right; padding-right: 10px">
                    Volver<a href="../index.jsp"><img src="../imagenes/iconos/volver.png" width="25" height="25" alt="Volver"/></a>
                </th>
            </table>
        </div>
        <fieldset class="wrapper">
            <legend>Listado de Sistemas de Origen</legend>
            <%
                if (mensaje != null && !mensaje.equals("null")) {
                    out.print("<div class=\"error\"><p>" + mensaje + "</p></div>");
                }
            %>
            <fieldset>
                <legend>Filtrar por</legend>
                <form method="get" action="../sistemaOrigen">
                    <table>
                        <td>Id: </td>
                        <td><input type="number" name="id"/></td>
                        <td>Nombre: </td>
                        <td><input type="text" name="nombre"/></td>
                        <td><input type="submit" name="action" value="Filtrar" src="../imagenes/iconos/busqueda.png" width="20" height="20"/></td>
                    </table>
                </form>
            </fieldset>
            <br/>
            <a href="agregarSistemaOrigen.jsp"><img src="../imagenes/iconos/bloc.png" width="40" height="40" style="margin-bottom: 5px"/></a>
            <br/>
            <fieldset>
                <table style="width: 100%;" border="1" class="tblAbm">
                    <tr>
                        <th style="width: 20%">Id</th>
                        <th style="width: 70%">Nombre</th>
                        <th style="width: 10%">Acciones</th>
                    </tr>
                    <%if (sistemas != null) {
                            for (SistemaOrigen sistema : sistemas) {%>
                    <tr>
                        <td style="width: 20%; text-align: center;"><%=sistema.getId()%></td>
                        <td style="width: 70%"><%=sistema.getNombre()%></td>
                        <td style="width: 10%">
                            <a href="../sistemaOrigen?action=Borrar&id=<%=sistema.getId()%>"><img src="../imagenes/iconos/basura.png" alt="Borrar" width="30" height="30"/></a>
                            <a href="../sistemaOrigen?action=Ver&id=<%=sistema.getId()%>"><img src="../imagenes/iconos/lapiz.png" alt="Editar" width="30" height="30"/></a>
                        </td>
                    </tr>      
                    <%}%>
                    <%}%>
                </table>
            </fieldset>
        </fieldset>
    </body>
</html>

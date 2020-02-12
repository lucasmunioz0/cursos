<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Origen</title>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <%
            String mensaje = String.valueOf(request.getSession().getAttribute("msg"));
        %>

        <header>
            <%@include file="topBanner.jsp"%>
        </header>
        <div>
            <table style="width: 100%">
                <th style="text-align: left">
                    <h1>Sistemas de Origen</h1>
                </th>
                <th style="text-align: right; padding-right: 10px">
                    Volver<a href="../sistemaOrigen?action=GetAll"><img src="../imagenes/iconos/volver.png" width="25" height="25" alt="Volver"/></a>
                </th>
            </table>
        </div>


        <fieldset class="wrapper">
            <legend>Agregar nuevo Sistema de Origen</legend>             
            <%
                if (mensaje != null && !mensaje.equals("null")) {
                    out.print("<div class=\"error\"><p>" + mensaje + "</p></div>");
                }
            %>
            <br/>
            <fieldset>
                <form method="post" action="../sistemaOrigen">
                    <table>
                        <tr>
                            <td class="firstColumn">Id:</td>
                            <td><input type="number" name="id"/></td>
                        </tr>
                        <tr>
                            <td class="firstColumn">Nombre:</td>
                            <td><input type="text" name="nombre"/></td>
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

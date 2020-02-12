<% request.setCharacterEncoding("UTF-8");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el Formulario</h1>
        <table border="1">
            <tr>
                <td>Usuario:</td>
                <td><%= request.getParameter("usuario")%></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><%= request.getParameter("password")%></td>
            </tr>
        </table>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

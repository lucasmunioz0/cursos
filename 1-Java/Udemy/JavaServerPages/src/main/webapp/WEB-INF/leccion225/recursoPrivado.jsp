<%
    String colorFondo = request.getParameter("colorFondo");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Recurso Privado</title>
    </head>
    <body bgcolor="<%= colorFondo %>">
        <p>Color aplicado: <%= colorFondo %> </p>
    </body>
</html>

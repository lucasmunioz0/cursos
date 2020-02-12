<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        Concatenación: <%= "Saludos" + " JSP" %>
        <br/>
        Operación Matemática: <%= 2 * 3 / 2 %>
        <br/>
        Session id: <%= session.getId() %>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

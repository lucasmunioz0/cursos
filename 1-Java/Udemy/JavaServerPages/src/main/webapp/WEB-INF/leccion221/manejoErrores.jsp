<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Manejo de errores</title>
    </head>
    <body>
        <h1>Manejo de errores</h1>
        <br/>
        Ocurrió una excepción: <%= exception.getMessage()%>
        <br/>
        <textarea cols="30" rows="5">
            <% exception.printStackTrace(new PrintWriter(out));%>
        </textarea>
    </body>
</html>

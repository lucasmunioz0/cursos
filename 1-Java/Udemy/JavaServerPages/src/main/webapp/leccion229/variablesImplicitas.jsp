<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Variables implícitas</title>
    </head>
    <body>
        <h1>EL y Variables implícitas</h1>
        <ul>
            <li>Nombre de la aplicación: ${pageContext.request.contextPath}</li>
            <li>Navegador del cliente: ${header["User-Agent"]}</li>
            <li>ID Session con cookie: ${cookie.JSESSIONID.value}</li>
            <li>ID Session con session: ${pageContext.session.id}</li>
            <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
            <li>Valor parámetro sintaxis de atributo: ${param.usuario}</li>
            <li>Valor parámetro sintaxis de índice: ${param["usuario"]}</li>
        </ul>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>

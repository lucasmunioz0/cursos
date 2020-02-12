<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lección 234</title>
    </head>
    <body>
        <h1>Lección 234 - Patrón MVC 2</h1>
        <br/>
        <div style="color:red;">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/rectangulo">
            Link al Servlet Controlador SIN parámetros
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/rectangulo?accion=agregaVariables">
            Link al Servlet Controlador para agregar las variables
        </a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/rectangulo?accion=listarVariables">
            Link al Servlet Controlador para listar variables
        </a>
    </body>
</html>

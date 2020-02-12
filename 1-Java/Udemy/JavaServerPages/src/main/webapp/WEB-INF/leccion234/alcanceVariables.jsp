<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alcance variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        Variable de request: 
        <ul>
            <li>Base: ${rectanguloRequest.base}</li>
            <li>Altura: ${rectanguloRequest.altura}</li>
            <li>Área: ${rectanguloRequest.area}</li>
        </ul>
        <br/>
        Variable de sesión:
        <ul>
            <li>Base: ${rectanguloSession.base}</li>
            <li>Altura: ${rectanguloSession.altura}</li>
            <li>Área: ${rectanguloSession.area}</li>
        </ul>
        <br/>
        Variable de aplicación: 
        <ul>
            <li>Base: ${rectanguloAplicacion.base}</li>
            <li>Altura: ${rectanguloAplicacion.altura}</li>
            <li>Área: ${rectanguloAplicacion.area}</li>
        </ul>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/leccion234/">Regresar al Inicio</a>
    </body>
</html>
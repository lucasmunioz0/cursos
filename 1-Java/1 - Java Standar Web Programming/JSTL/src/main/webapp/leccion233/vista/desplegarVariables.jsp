<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>
        Variable en alcance de request: ${mensaje}
        <br/>
        <br/>
        Variable en alcance de sesión:
        <br/>
        Rectángulo:
        <br/>
        Base: ${rectangulo.base}
        <br/>
        Altura: ${rectangulo.altura}
        <br/>
        Área: ${rectangulo.area}
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/leccion233">Regresar al inicio</a>
    </body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Getter</title>
    </head>
    <body>
        <h1>Getter Rectángulo</h1>
        <jsp:useBean id="rectangulo" class="com.udemy.curso.leccion227.Rectangulo" scope="request"/>
        Valor Base: <jsp:getProperty name="rectangulo" property="base"/>
        <br/>
        Valor Altura: <jsp:getProperty name="rectangulo" property="altura" />
        <br/>
        Valor Área: <jsp:getProperty name="rectangulo" property="area" />
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

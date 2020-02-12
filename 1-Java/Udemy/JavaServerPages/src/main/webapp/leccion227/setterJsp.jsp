<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Setter</title>
    </head>
    <body>
        <h1>Setter Rectángulo</h1>
        <jsp:useBean id="rectangulo" class="com.udemy.curso.leccion227.Rectangulo" scope="request" />
        Modificamos los atributos
        <br/>
        <br/>
        <%
            int baseValor = 5;
            int altura = 10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=altura%>"/>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

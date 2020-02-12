<% request.setCharacterEncoding("UTF-8");%>
<% String colorFondo = request.getParameter("colorFondo"); 
    if(colorFondo == null || colorFondo.trim().isEmpty()){
        colorFondo = "white";
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fondo Color</title>
    </head>
    <body bgcolor="<%=colorFondo%>">
        <h1>JSP cambio de color</h1>
        <br/>
        Color de fondo aplicado: <%=colorFondo%>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

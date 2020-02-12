<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br/>
        <%-- Scriptlet para enviar información al navegador --%>
        <%
            out.println("Saludos desde un scriptlet");
        %>
        <br/>
        <%-- Scriptlet para manipular los objetos implicitos --%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.println("Nombre de la aplicación: " + nombreAplicacion);
        %>
        <br/>
        <%-- Scriptlet con código condicionado --%>
        <%
            if (session != null && session.isNew()) {
        %>
        la sesion es nueva
        <%
        } else if (session != null) {
        %>
        la sesion NO es nueva
        <% }%>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>

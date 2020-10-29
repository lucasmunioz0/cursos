<%-- 
    Document   : listado
    Created on : 27-oct-2020, 0:06:30
    Author     : Lucas
--%>

<%@page import="java.util.List"%>
<%@page import="mx.com.gm.domain.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% List<Persona> personas = (List<Persona>) request.getAttribute("personas"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado personas</title>
    </head>
    <body>
        <table border="1">
            <caption>Listado de personas</caption>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="persona" items="${personas}">
                    <tr>
                        <td>${persona.idPersona}</td>
                        <td>${persona.nombre}</td>
                        <td>${persona.apellido}</td>
                        <td>${persona.email}</td>
                        <td>${persona.telefono}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

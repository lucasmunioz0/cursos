<%-- 
    Document   : index
    Created on : 11-ene-2020, 13:22:06
    Author     : lucas
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lección 214</title>
    </head>
    <body>
        <h1>Lección 214 - Hola Mundo</h1>
        <ul>
            <li> <% out.println("Hola Mundo con Scriptlets"); %></li>
            <li> ${"Hola Mundo con Expresión Language (EL)"}</li>
            <li> <%="Hola Mundo con Expresiones"%></li>
            <li> <c:out value="Hola Mundo con JSTL"/></li>
        </ul>
    </body>
</html>

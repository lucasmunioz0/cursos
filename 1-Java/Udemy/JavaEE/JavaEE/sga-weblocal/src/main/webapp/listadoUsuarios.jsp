<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de usuarios</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <ul>
            <c:forEach var="user" items="${users}">
                <li>${user}</li>
            </c:forEach>
        </ul>
    </body>
</html>

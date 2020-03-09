<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de personas</title>
    </head>
    <body>
        <h1>Personas</h1>
        <ul>
            <c:forEach var="person" items="${persons}">
                <li>${person}</li>
            </c:forEach>
        </ul>
    </body>
</html>

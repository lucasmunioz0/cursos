<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core (Jsp Standard Tag Library)</h1>
        <!-- Manejo de variables -->
        <!-- Definimos la variable -->
        <c:set var="nombre" value="Hola Ernesto"/>
        <!-- Desplegamos el valor de la variable -->
        <c:out value="${nombre}" />
        <br/>
        <br/>
        Variable con código HTML:
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <br/>
        <br/>
        <!-- Codigo condicional, uso de if -->
        <c:set var="bandera" value="true"/>
        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>
        <br/>
        <!-- Codigo condicional, uso de switch -->
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    <br/>
                    Opción 1 seleccionada
                </c:when>
                <c:when test="${param.opcion == 2}">
                    <br/>
                    Opción 2 seleccionada
                </c:when>
                <c:otherwise>
                    <br/>
                    Opción proporcionada desconocida: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <!-- Iteracion de un arreglo -->
        <%
            String nombres[] = {"Claudia", "Pedro", "Juan"};
            request.setAttribute("nombres", nombres);
        %>
        <br/>
        Lista de Nombres:
        <br/>
        <ul>
            <c:forEach var="nombre" items="${requestScope.nombres}">
                <li>${nombre}</li>
            </c:forEach>
        </ul>
    </body>
</html>

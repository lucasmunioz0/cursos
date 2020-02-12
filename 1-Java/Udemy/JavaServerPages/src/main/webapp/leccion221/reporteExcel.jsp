<%@page errorPage="../WEB-INF/leccion221/manejoErrores.jsp" %>
<%@page import="com.udemy.curso.leccion221.Conversiones, java.util.Date"%>
<%@page contentType="application/vnd.ms-excel"%>
<%  
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br/>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripci�n</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java.</td>
                <td>Aprenderemos la sintaxis b�sica de Java.</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
            <tr>
                <td>2. Programaci�n con Java.</td>
                <td>Pondremos en pr�ctica, conceptos de la programaci�n orientada a objetos.</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
        </table>
    </body>
</html>

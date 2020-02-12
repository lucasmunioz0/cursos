<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lección 216</title>
    </head>
    <body>
        <h1>Lección 216 - Ejemplo de Expresiones JSPs</h1>
        <br/>
        <a href="expresiones.jsp">Link al JSP de Expresiones</a>
        <br/>
        <h4>Formulario HTML</h4>
        <form name="form1" action="procesarFormulario.jsp" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="usuario"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"/></td>                    
                </tr>
            </table>            
        </form>
    </body>
</html>

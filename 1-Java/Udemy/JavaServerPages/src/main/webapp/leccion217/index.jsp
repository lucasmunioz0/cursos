<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lección 217</title>
    </head>
    <body>
        <h1>Lección 217 - Scriptlets con JSPs</h1>
        <br/>
        <a href="scriptlets.jsp">Link al JSP de Scriptlets</a>
        <br/>
        <br/>
        <form name="form1" action="fondoColor.jsp" method="post">
            Proporciona el color de fondo (ej. red, blue, yellow, white, etc)
            <input type="text" name="colorFondo" />
            <br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lección 225</title>
    </head>
    <body>
        <h1>Lección 225 - Inclusión Dinámica</h1>
        <br/>
        <jsp:include page="paginas/recursoPublico.jsp"></jsp:include>
        <br/>
        <jsp:include page="/WEB-INF/leccion225/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow" />
        </jsp:include>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gobierno de Datos</title>
        <link rel="stylesheet" href="../css/estilos.css">
    </head>
    <body>
        <header>
            <%@include file="calidadDatos/topBanner.jsp"%>
        </header>
        <section>
            <ul>
                <li><a href="sistemaOrigen?action=GetAll">Sistemas de Origen</a></li>
                <li><a href="tipoIncidente?action=GetAll">Tipos de Incidentes</a></li>
                <li><a href="incidente?action=GetAll">Incidentes</a></li>
            </ul>
        </section>
    </body>
</html>

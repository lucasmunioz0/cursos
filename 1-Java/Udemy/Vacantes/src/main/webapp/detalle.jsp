<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">    
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">
        <title>${vacante.nombre}</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/justified-nav.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">
            <div class="masthead">
                <h3 class="text-muted">My Company</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="homepage">Inicio</a></li>
                        <li><a href="login?action=login">Administración</a></li>
                        <li><a href="acerca.jsp">Acerca</a></li>           
                    </ul>
                </nav>
            </div>
            <form method ="post" action="#" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
                </div>        
                <button type="submit" class="btn btn-success">Buscar</button>
            </form>
            <br><br><br>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">${vacante.id}</h3>
                </div>
                <div class="panel-body">
                    <h5><b>Vacante</b>: ${vacante.nombre}</h5>
                    <h5><b>Publicado</b>: ${vacante.fechaPublicacion}</h5>                             
                    <b>Descripción:</b><br>
                    <p class="text-justify">${vacante.descripcion}</p>
                    <b>Detalles de la vacante</b>:<br>
                    ${vacante.detalle}
                    
                    <p><a class="btn btn-default btn-success" title="Enviar Curriculm Vitae para aplicar a esta vacante." href="vacantes?action=enviarCV&id=${vacante.id}" role="button">Enviar CV</a></p>
                </div>
            </div>      
            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; 2016 My Company, Inc.</p>
            </footer>

        </div> <!-- /container -->

    </body>
</html>

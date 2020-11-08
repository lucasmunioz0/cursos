<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">    
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">
        <title>Departamento de Recursos Humanos - My Company</title>
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

            <form method ="post" action="buscar" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
                </div>        
                <button type="submit" class="btn btn-success">Buscar</button>
            </form>

            <div class="jumbotron">
                <h2>¡ENCUENTRA TU TRABAJO IDEAL!</h2>
                <p class="lead text-justify">Bienvenido a My Company, aquí podrás encontrar ofertas de empleos 
                    que sean adecuados a tu perfil, experiencia y ubicación. 
                    Es muy fácil de usar, solo haz clic en una vacante, ingresa para ver los detalles y envíanos tu CV en formato 
                    PDF o DOCX. Nosotros revisaremos tu CV y posteriormente te contactaremos.<br><br>

                <p><a class="btn btn-lg btn-success" href="vacantes?action=all" role="button">Ver más Ofertas</a></p>                
            </div>

            <h1>Ofertas recientes</h1>
            <div class="row">
                <c:forEach var="vacante" items="${vacantes}">
                    <div class="col-lg-4">
                        <h2>${vacante.nombre}</h2>
                        <p class="text-danger text-justify">${vacante.descripcion}</p>
                        <p class="text-justify">${vacante.detalle}</p>
                        <p><a class="btn btn-primary" href="vacantes?action=ver&idVacante=${vacante.id}" role="button">Ver detalles &raquo;</a></p>
                    </div>
                </c:forEach>
            </div>
            <footer class="footer">
                <p>&copy; 2016 My Company, Inc.</p>
            </footer>
        </div>
    </body>
</html>

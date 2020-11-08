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
        <title>Lista de todas las vacantes</title>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/justified-nav.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">

            <!-- The justified navigation menu is meant for single line per list item.
                 Multiple lines will require custom code not provided by Bootstrap. -->
            <div class="masthead">
                <h3 class="text-muted">My Company</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li><a href="homepage">Inicio</a></li> 
                        <li><a href="login?action=login">Administraci�n</a></li>
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

            <div class="panel panel-default">               
                <% Object mensaje = request.getAttribute("mensaje");
              if (mensaje != null && mensaje.toString().contains("error")) {%>
                <%="<div class=\"alert alert-danger\">" + mensaje + "</div>"%>
                <% } else if (mensaje != null) { %>
                <%="<div class=\"alert alert-info\">" + mensaje + "</div>"%>
                <%}%>
                <div class="panel-heading">
                    <h3 class="panel-title"><b>Lista de Vacantes</b></h3>
                </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th class="left">ID</th>
                                <th>Vacante</th>
                                <th>Publicado</th>                
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="vacante" items="${vacantes}">
                            <tr>
                                <td class="left">${vacante.id}</td>
                                <td>${vacante.nombre}</td>
                                <td>${vacante.fechaPublicacion}</td>
                                <td>
                                    <a class="btn btn-default" href="vacantes?action=ver&idVacante=${vacante.id}" role="button">Ver Detalles</a>
                                    <c:if test="${usuario != null && usuario.id > 0}">
                                        <a class="btn btn-default" href="vacantes?action=delete&idVacante=${vacante.id}" role="button">Eliminar</a>
                                    </c:if>                     
                                </td>  
                            </tr>
                        </c:forEach>
                        </tbody>           
                    </table>
                </div>
            </div>

            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; 2016 My Company, Inc.</p>
            </footer>

        </div> <!-- /container -->

    </body>
</html>

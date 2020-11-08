<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">    
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="favicon.ico">

        <title>Ingresar como Administrador</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

    </head>

    <body>

        <div class="container">
            <center>
                <img src="images/lock.png"><br>
            </center>        
            <form class="form-signin" method="post" action="login">
                <h2 class="form-signin-heading">Ingreso al sistema</h2>
                <label for="user" class="sr-only">Nombre de usuario</label>
                <input type="text" id="user" name="usuario" class="form-control" placeholder="Escriba nombre de usuario" required autofocus>
                <label for="pass" class="sr-only">Password</label>
                <input type="password" id="pass" name="password" class="form-control" placeholder="Escriba su password" required>
                <% Object mensaje = request.getAttribute("mensaje");
            if (mensaje != null) {%>
                <%="<p class=\"text-danger\">" + mensaje + "</p>"%>
                <%}%>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
            </form>

        </div> <!-- /container -->

    </body>
</html>
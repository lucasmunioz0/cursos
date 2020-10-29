<%-- 
    Document   : index
    Created on : 27-oct-2020, 9:27:16
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Welcome</title>
    </head>
    <body class="container">
        <h1>Student App</h1>
        <a href="${page.request.contextPath}students">View Students</a>
    </body>
</html>

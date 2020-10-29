<%-- 
    Document   : student
    Created on : 27-oct-2020, 9:24:49
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page pageEncoding="UTF-8" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <h1>Student</h1>
        <form action="${pageContext.request.contextPath}/students" method="post">
            <input type="number" value="${student.id}" hidden="hidden" name="id">
            <div class="my-1">
                <input type="submit" class="btn btn-primary" value="Save" name="action" />
                <input type="submit" class="btn btn-danger" value="Delete" name="action" />
<!--                <button type="submit" class="btn btn-primary" value="save">Save</button>
                <a href="${pageContext.request.contextPath}/students?id=${student.id}&action=delete" class="btn btn-danger">Delete</a>-->
                <a href="${pageContext.request.contextPath}/students" class="btn btn-secondary">Back</a>
            </div>
            <fieldset class="my-1">
                <legend>Personal Data</legend>
                <div class="form-row">

                    <div class="col-12 col-md-6">
                        <label>Name:</label>
                        <input type="text" class="form-control" name="name" value="${student.name}"/>
                    </div>
                    <div class="col-12 col-md-6">
                        <label>Last Name:</label>
                        <input type="text" class="form-control" name="lastName" value="${student.lastName}"/>
                    </div>

                </div>
            </fieldset>
            <fieldset class="my-1">
                <legend>Address Data</legend>
                <div class="form-row">

                    <div class="col-12 col-md-6">
                        <label>Address:</label>
                        <input type="text" class="form-control" name="address" value="${student.address.address}"/>
                    </div>
                    <div class="col-12 col-md-3">
                        <label>N°:</label>
                        <input type="text" class="form-control" name="addressNumber" value="${student.address.addressNumber}"/>
                    </div>
                    <div class="col-12 col-md-3">
                        <label>Country:</label>
                        <input type="text" class="form-control" name="country" value="${student.address.country}"/>
                    </div>
                </div>
            </fieldset>
        </form>
    </body>
</html>

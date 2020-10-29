<%-- 
    Document   : list
    Created on : 27-oct-2020, 9:14:34
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Student</title>
    </head>
    <body class="container">
        <h1>Student List</h1>
        <a class="btn btn-primary my-1" href="${pageContext.request.contextPath}/redirect">New</a>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>
                                <a href='${page.request.contextPath}students?id=${student.id}'>${student.id}</a>
                            </td>
                            <td>${student.name} ${student.lastName}</td>
                            <td>${student.address.address} ${student.address.addressNumber} ${student.address.country}</td>
                            <td>${student.contact.email}</td>
                            <td>${student.contact.phone}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>

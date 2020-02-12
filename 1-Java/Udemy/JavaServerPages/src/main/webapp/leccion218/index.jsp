<%-- Agregamos una declaración de JSP --%>
<%! 
    //Declaramos una variable con su método get
    private String usuario = "Alberto";

    public String getUsuario(){
        return this.usuario;
    }

    //Declaramos un contador de visitas
    private int contadorVisitas = 1;

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lección 218</title>
    </head>
    <body>
        <h1>Lección 218 - Declaraciones con JSPs</h1>
        Valor usuario por medio del atributo: <%= this.usuario %>
        <br/>
        Valor usuario por medio del método: <%= getUsuario() %>
        <br/>
        Contador de Visitas: <%=contadorVisitas++%>
        <a href="scriptlets.jsp">Link al JSP de Scriptlets</a>
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.usuarios"%>
<%@page import="java.util.List"%>
<%
    List<usuarios> usuarios = (List<usuarios>) request.getAttribute("usuarios");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
        <h1>Listado de Usuarios</h1>
        <p><a class="btn btn-success btn-lg" href="UsuarioController?action=add">Nuevo</a></p>
        <table class="table table-success table-striped" border="2">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Clave</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <c:forEach var="item" items="${usuarios}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.correo}</td>
                    <td>${item.clave}</td>
                    <td><a class="btn btn-warning" href="UsuarioController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a class="btn btn-danger" href="UsuarioController?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>              
            </c:forEach>
        </table>
        
        <a class="btn btn-danger btn-lg" href="index.jsp">Volver</a>
         </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

    </body>
</html>

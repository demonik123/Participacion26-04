<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.usuarios"%>
<%
    usuarios usuario = (usuarios) request.getAttribute("usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <h1>Nuevo Registro</h1>
        <form action="UsuarioController" method="post" class="row g-3">
            <input type="hidden" name="id" value="${usuario.id}" />
            <div class="form-floating mb-2 col-md-12">
                <input type="text" class="form-control" name="Nombre" value="${usuario.nombre}"  id="floatingInput" placeholder="name@example.com">
                <label for="floatingInput">Nombre</label>
            </div>
            <div class="form-floating mb-2 col-md-12">
                <input type="text" class="form-control" name="Correo" value="${usuario.correo}" id="floatingInput" placeholder="name@example.com">
                <label for="floatingInput">Correo</label>
            </div>
            <div class="form-floating mb-2 col-md-12">
                <input type="text" class="form-control" name="Clave" value="${usuario.clave}" id="floatingInput" placeholder="name@example.com">
                <label for="floatingInput">Password</label>
            </div>
       
                <input type="submit" class="btn btn-primary btn-lg" value="Enviar" />
              
        </form>
        </div>     
    </body>
</html>

<%-- 
    Document   : mostrar
    Created on : 04-nov-2021, 17:32:59
    Author     : DAW-A
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Automovil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Concesionario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Alertify -->
        <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
        <!-- END Alertify -->
        <style type="text/css">
            body {
                text-align: center;
            }
            .button {
                width: 250px;
                background-color: lightgrey;
                border: none;
                color: black;
                padding: 10px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 15px;
                margin: 3px 0;
                transition-duration: 0.4s;
                cursor: pointer;
            }
            .button-a {
                width: 230px;
            }
            .button:hover {
                background-color: purple;
                color: white;
            }
        </style>
    </head>
    <body>
        <h1>INSERCIÓN DE AUTOMÓVL</h1>
        <form action="Controlador" method="POST">
            <label for="categoria">Categoría</label><br>
            <input type="text" id="categoria" name="categoria"><br>
            <label for="precio">Precio</label><br>
            <input type="number" id="precio" name="precio" min="0"><br>
            <label for="marca">Marca</label><br>
            <input type="text" id="marca" name="marca"><br>
            <label for="modelo">Modelo</label><br>
            <input type="text" id="modelo" name="modelo"><br>
            <label for="fab">Año de fabricación</label><br>
            <input type="number" id="fab" name="fab" min="1900" max="2099" step="1"><br>
            <label for="foto">Foto</label><br>
            <input type="text" id="foto" name="foto"><br>
            <br>
            <button class="button" type="submit" name="action" value="insertarDatos">Añadir automóvl</button><br>
            <button class="button" type="submit" name="action" value="mostrar">Listado de automóviles</button><br>
            <button class="button" type="button" onclick="location.href='index.html'">Inicio</button>
        </form>
        <script type="text/javascript">
            alertify.set('notifier','position', 'bottom-center');
            ${msg}
        </script>
    </body>
</html>

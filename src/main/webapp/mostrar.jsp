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
        <!-- Alertify -->
        <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
        <!-- END Alertify -->
        <style type="text/css">
            * {
                box-sizing: border-box;
                margin: 0;
            }
            body {
                text-align: center;
            }
            h1 {
                margin: 10px;
            }
            .fake-a {
                border: 0;
                background-color: rgb(0,0,0,0);
                color: blue;
            }
            .fake-a:hover {
                cursor: pointer;
                color: red;
            }
            .fake-a:focus {
                outline: none;
                box-shadow: none;
            }
            .grid {
                display: grid;
                grid-template-columns: 33vw 33vw 33vw;
                margin: 10px;
                overflow: hidden;
            }
            .grid-item {
                margin: 10px;
            }
            .grid-item img {
                width: 60%;
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
            .button:hover {
                background-color: purple;
                color: white;
            }
            .paginas {
                display: flex;
                width: 30%;
                flex-wrap: wrap;
                justify-content: space-around;
                margin: auto;
                text-align: center;
            }
            .pag {
                border: 0;
                background: none;
                color: blue;
                font-size: 15px;
            }
            .pag:hover {
                cursor: pointer;
                color: red;
            }
            .active {
                color: black;
                background-color: transparent;
                border: transparent;
                margin: 0;
                padding: 0;
                text-align: center;
                font-size: 15px;
            }
        </style>
    </head>
    <body>
        <h1>CONCESIONARIO</h1>
        <form action="Controlador" method="POST">
            <button class="button" type="submit" name="action" value="insertar">Añadir automóvil</button>
            <button class="button" type="button" onclick="location.href='index.html'">Inicio</button>
        </form>
        <div class="grid">
            <c:forEach var="a" items="${lista}">
                <div class="grid-item">
                    <h3>${a.marca} ${a.modelo} ${a.fab}</h3>
                    <img src="img/${a.foto}">
                    <p>Categoría: ${a.categoria}</p>
                    <p>Precio: ${a.precio} €</p>
                    <form action="Controlador" method="POST">
                        <input type="hidden" name="id" value="${a.id}"> 
                        <td><button class="fake-a" type="submit" name="action" onclick="return confirm('¿De verdad quiere eliminar el producto?')" value="borrar">Borrar</button></td>
                        <td><button class="fake-a" type="submit" name="action" value="actualizar">Actualizar</button></td>
                    </form>
                </div>
            </c:forEach>
        </div>
        <div class="paginas">
            <form action="Controlador" method="POST">
                <input type="hidden" name="pag" value="1">
                <button class="pag" type="submit" name="action" value="mostrar"><<</button>
            </form>
            <c:if test="${pag > 1}">  
                  <form action="Controlador" method="POST">
                    <input type="hidden" name="pag" value="${pag-1}">
                    <button class="pag" type="submit" name="action" value="mostrar"><</button>
                </form>
            </c:if> 
            <c:forEach var="p" items="${paginas}">
                <form action="Controlador" method="POST">
                    <input type="hidden" name="pag" value="${p}">
                    <c:if test="${pag == p}">  
                        <a class="active">${p}</a>
                    </c:if> 
                    <c:if test="${pag != p}">  
                        <button class="pag" type="submit" name="action" value="mostrar">${p}</button>
                    </c:if> 
                </form>
            </c:forEach>
            <c:if test="${pag < num_pag}">  
                  <form action="Controlador" method="POST">
                    <input type="hidden" name="pag" value="${pag+1}">
                    <button class="pag" type="submit" name="action" value="mostrar">></button>
                </form>
            </c:if> 
            <form action="Controlador" method="POST">
                <input type="hidden" name="pag" value="${num_pag}">
                <button class="pag" type="submit" name="action" value="mostrar">>></button>
            </form>
        </div>
        <script type="text/javascript">
            alertify.set('notifier','position', 'bottom-center');
            ${msg}
        </script>
    </body>
</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        

        <h1>Registro de calificaciones</h1>
        <form action="PostNuevo" method="GET">

            <label>Nombre del estudiante:</label>
            <input type="text" name="nombres" ><br>

            <label>Primer parcial(sobre 30 pts):</label>
            <input type="number" name="parcialUno" ><br>

            <label>Segundo parcial(sobre 30 pts):</label>
            <input type="number" name="parcialDos" ><br>

            <label>Examen final(sobre 40 pts):</label>
            <input type="number" name="parcialTres" ><br>

            <input type="submit" value="Enviar">
            

        </form>

    </body>
</html>

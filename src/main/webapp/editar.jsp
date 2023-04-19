<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Calificacion"%>
<%
Calificacion cal = (Calificacion) request.getAttribute("calificacion");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        

        <h1>Registro de calificaciones</h1>
        <form action="PostEditar" method="POST">

			<label>ID: <%=cal.getId()%> </label><br>
			<input type="number" name="id" value="<%=cal.getId()%>" hidden="">

            <label>Nombre del estudiante:</label>
            <input type="text" name="nombres" value="<%=cal.getNombre()%>"><br>

            <label>Primer parcial(sobre 30 pts):</label>
            <input type="number" name="parcialUno" value="<%=cal.getP1()%>"><br>

            <label>Segundo parcial(sobre 30 pts):</label>
            <input type="number" name="parcialDos" value="<%=cal.getP2()%>"><br>

            <label>Examen final(sobre 40 pts):</label>
            <input type="number" name="parcialTres" value="<%=cal.getEf()%>"><br>

            <input type="submit" value="Enviar">
            
        </form>

    </body>
</html>

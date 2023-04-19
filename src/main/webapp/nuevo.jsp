<%@page import="com.emergentes.modelo.SessionPersona"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
	//Obtenemos la sesión del usuario
	HttpSession sessionEstablecida = request.getSession();
	
	// Recuperamos el valor del atributo "usuario" de la sesión
	SessionPersona persona = (SessionPersona) sessionEstablecida.getAttribute("personasession");
	
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        
        <%
	if (persona != null) {
	%>
		<p>
                        <p>id del sergidor que asigna el valor de id unico para la sesion: <%=sessionEstablecida.getId()%> </p>
                        <br>
			<%=persona.getId()%>
			<br>
			<%=persona.getNombre()%>
			<br>
			<%=persona.getNavegador()%>
			<br>
		</p>
	<%
	}
	%>
        
        

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

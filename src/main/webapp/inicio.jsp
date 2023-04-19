<%@page import="com.emergentes.modelo.SessionPersona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Calificacion"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
	ArrayList<Calificacion> lista = (ArrayList<Calificacion>) request.getAttribute("listaCalificaciones");

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
        <title>Examen</title>
    </head>
    <body>


	<%
	if (persona != null) {
	%>
		<p>
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

        <a href="PreNuevo">NUEVO</a>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>

            <%
            if (lista != null) {
                    for (Calificacion item : lista) {
            %>
                        <tr>
                            <td><%= item.getId()%></td>
                            <td><%= item.getNombre()%></td>
                            <td><%= item.getP1()%></td>
                            <td><%= item.getP2()%></td>
                            <td><%= item.getEf()%></td>
                            <td><%= item.getNota()%></td>
                            <td><a href="PreEditar?id=<%=item.getId()%>">Editar</a></td>
                            <td><a href="PreEliminar?id=<%=item.getId()%>">Eliminar</a></td>
                        </tr>
            <%
                    }
                }
            %>

        </table>


    </body>
</html>

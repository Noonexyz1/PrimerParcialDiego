
package com.emergentes.controller;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.modelo.Calificacion;
import com.emergentes.servicio.InterfaceServicio;
import com.emergentes.servicio.Servicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.faces.view.ActionSource2AttachedObjectTarget;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PreInicio", urlPatterns = {"/"})
public class PreInicio extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InterfaceServicio servicio = new Servicio();
		servicio.evaluarSesionActiva(request);

		List<Calificacion> lista = servicio.listaCalificaciones(request);
		
		request.setAttribute("listaCalificaciones", lista);
		//ME PARACE QUE TODO ESTA YENDO AL INDEX!!!!!!!!!
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		//request.getRequestDispatcher("/PostInicio").forward(request, response);
		
		
		/*
		 * NOTA MUY IMPORTANTE
		 * Cuando se tiene un servlet con / en la anotacion de la cabeza de la clase,
		 * y despues tienes un index.jsp dentro de ese /
		 * lo primero que hara sera siempre llamar al index.jsp
		 * ya que / solo es la ruta principal, entonces en la ruta principal, el servidor,
		 * solamente ejecutara el primer index.jsp que encuentre
		 * (lo que hize era que cambie de nombre el index.jsp ahora todo va genial)
		 * era como si le volviera a repetir que desde / vaya al index.jsp cuando eso era lo que hacia por dentro
		 * 
		 * EL INDEX.JSP TIENE MAS PRIORIDAD que /
		 * cuando el servidor vea que no hay un index entoces recien hace caso al /
		 * 
		 * Al momento de iniciar el servidor, el servidor lo primero que hace es ver donde esta el index
		 * si no lo encuentra, entonce recien consulta por los servlets, en mi caso, recien hara caso al / con el jsp
		 * que tengo programado para despachar.
		 * 
		 * Hay una forma de establecer un /nombre como principal con el descriptor
		 * 
		 * */
		

	}
    
    
    
}

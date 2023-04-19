package com.emergentes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emergentes.modelo.Calificacion;
import com.emergentes.servicio.InterfaceServicio;
import com.emergentes.servicio.Servicio;

@WebServlet(name = "PreEditar", urlPatterns = {"/PreEditar"})
public class PreEditar extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InterfaceServicio servicio = new Servicio();
		
		request.setAttribute("calificacion", servicio.buscarRegistro(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("editar.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

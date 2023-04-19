package com.emergentes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emergentes.servicio.InterfaceServicio;
import com.emergentes.servicio.Servicio;

@WebServlet(name = "PostEditar", urlPatterns = {"/PostEditar"})
public class PostEditar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		InterfaceServicio servicio = new Servicio();
		
		servicio.editarRegistro(request);

		request.setAttribute("listaCalificaciones", servicio.listaCalificaciones(request));
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

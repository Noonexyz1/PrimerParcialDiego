package com.emergentes.controller;

import com.emergentes.datos.ListaCalificacionesDatos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emergentes.servicio.Servicio;
import com.emergentes.servicio.IServicio;
import com.emergentes.servicio.RegistroManager;
import com.emergentes.servicio.SesionManager;

@WebServlet(name = "PreEditar", urlPatterns = {"/PreEditar"})
public class PreEditar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IServicio servicio = new Servicio(
                new ListaCalificacionesDatos(),
                new RegistroManager(),
                new SesionManager()
        );

        request.setAttribute("calificacion", servicio.buscarRegistroServicio(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

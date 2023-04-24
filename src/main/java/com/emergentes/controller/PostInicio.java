package com.emergentes.controller;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.modelo.Calificacion;
import com.emergentes.servicio.Servicio;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.servicio.IServicio;
import com.emergentes.servicio.RegistroManager;
import com.emergentes.servicio.SesionManager;

@WebServlet(name = "PostInicio", urlPatterns = {"/PostInicio"})
public class PostInicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IServicio servicio = new Servicio(
                new ListaCalificacionesDatos(),
                new RegistroManager(),
                new SesionManager()
        );

        List<Calificacion> lista = servicio.listaCalificaciones(request);

        request.setAttribute("listaCalificaciones", lista);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        //request.getRequestDispatcher("/").forward(request, response);

    }

}

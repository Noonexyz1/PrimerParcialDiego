package com.emergentes.controller;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.servicio.Servicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.servicio.IServicio;
import com.emergentes.servicio.RegistroManager;
import com.emergentes.servicio.SesionManager;

@WebServlet(name = "PreEliminar", urlPatterns = {"/PreEliminar"})
public class PreEliminar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IServicio servicio = new Servicio(
                new ListaCalificacionesDatos(),
                new RegistroManager(),
                new SesionManager()
        );
        servicio.eliminarRegistroServicio(request);

        //request.setAttribute("listaCalificaciones", servicio.listaCalificaciones());
        request.getRequestDispatcher("PostEliminar").forward(request, response);

        //request.setAttribute("listaCalificaciones", servicio.listaCalificaciones());
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        //request.setAttribute("listaCalificaciones", servicio.listaCalificaciones());
        //request.getRequestDispatcher("/").forward(request, response);
    }

}

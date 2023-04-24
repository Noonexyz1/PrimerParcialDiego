package com.emergentes.controller;

import com.emergentes.servicio.Servicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.servicio.IServicio;

@WebServlet(name = "PostEliminar", urlPatterns = {"/PostEliminar"})
public class PostEliminar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IServicio servicio = new Servicio();

        request.setAttribute("listaCalificaciones", servicio.listaCalificaciones(request));
        request.getRequestDispatcher("inicio.jsp").forward(request, response);
        //request.getRequestDispatcher("/").forward(request, response);

    }

}

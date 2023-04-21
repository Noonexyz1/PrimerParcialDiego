
package com.emergentes.controller;


import com.emergentes.servicio.InterfaceServicio;
import com.emergentes.servicio.Servicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PreEliminar", urlPatterns = {"/PreEliminar"})
public class PreEliminar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InterfaceServicio servicio = new Servicio();
        servicio.eliminarRegistroServicio(request);
        
        //request.setAttribute("listaCalificaciones", servicio.listaCalificaciones());
        request.getRequestDispatcher("PostEliminar").forward(request, response);
        
        //request.setAttribute("listaCalificaciones", servicio.listaCalificaciones());
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        
        //request.setAttribute("listaCalificaciones", servicio.listaCalificaciones());
        //request.getRequestDispatcher("/").forward(request, response);
        
    }


}

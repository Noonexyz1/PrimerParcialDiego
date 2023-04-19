
package com.emergentes.controller;

import com.emergentes.servicio.InterfaceServicio;
import com.emergentes.servicio.Servicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PostEliminar", urlPatterns = {"/PostEliminar"})
public class PostEliminar extends HttpServlet {


 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    	InterfaceServicio servicio = new Servicio();
        
        request.setAttribute("listaCalificaciones", servicio.listaCalificaciones(request));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    	//request.getRequestDispatcher("/").forward(request, response);
        
    }

}

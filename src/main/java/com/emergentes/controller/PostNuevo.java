
package com.emergentes.controller;

import com.emergentes.servicio.InterfaceServicio;
import com.emergentes.servicio.Servicio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostNuevo", urlPatterns = {"/PostNuevo"})
public class PostNuevo extends HttpServlet {
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        InterfaceServicio servicio = new Servicio();
        servicio.nuevoRegistroServicio(request);
        
        //no tengo un metodo que me permita pasar listas  a otro objeto
        //request.setAttribute("listaCalificaciones", servicio.listaCalificaciones(request));
        //request.getRequestDispatcher("index.jsp").forward(request, response);
        request.getRequestDispatcher("/").forward(request, response);
        //request.getRequestDispatcher("/PostInicio").forward(request, response);
        
        
        
    }
    

}

package com.emergentes.servicio;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.modelo.Calificacion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class Servicio implements InterfaceServicio {

    @Override
    public List<Calificacion> listaCalificaciones(HttpServletRequest request) {
        //me creo una instancia de esta clase para acceder al atributo statico privado
        //que tiene esa clase

        if (request.getAttribute("listaCalificaciones") == null) {
            return new ListaCalificacionesDatos().getCalificacionesData();

        } else {

            return (List<Calificacion>) request.getAttribute("listaCalificaciones");

        }

    }

    @Override
    public void nuevoRegistroServicio(HttpServletRequest request) {
        RegistroManager manager = new RegistroManager();
        manager.nuevoRegistro(request);
    }
    
    @Override
    public Calificacion buscarRegistroServicio(int id) {
        RegistroManager manager = new RegistroManager();
        return manager.buscarRegistro(id);
    }

    @Override
    public void eliminarRegistroServicio(HttpServletRequest request) {
         RegistroManager manager = new RegistroManager();
         manager.eliminarRegistro(request);
    }

    @Override
    public void editarRegistroServicio(HttpServletRequest request) {
         RegistroManager manager = new RegistroManager();
         manager.editarRegistro(request);
    }

    
    
    @Override
    public void evaluarSesionActivaServicio(HttpServletRequest request) {
        SesionManager sesion = new SesionManager();
        sesion.evaluarSesionActiva(request);
    }

    @Override
    public boolean isSessionReadyServicio(HttpServletRequest request) {
       SesionManager sesion = new SesionManager();
       return sesion.isSessionReady(request);
    }

    @Override
    public void establecerSesionServicio(boolean b, HttpServletRequest request) {
        SesionManager sesion = new SesionManager();
        sesion.establecerSesion(b, request);
    }
    
    
}

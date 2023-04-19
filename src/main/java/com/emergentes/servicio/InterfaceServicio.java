
package com.emergentes.servicio;

import com.emergentes.modelo.Calificacion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface InterfaceServicio {
    public List<Calificacion> listaCalificaciones(HttpServletRequest request);
    public void nuevoRegistro(HttpServletRequest request);
    public Calificacion buscarRegistro(int id);
    public void eliminarRegistro(HttpServletRequest request);
    public void editarRegistro(HttpServletRequest request);
    
    //para las Sesiones
    public boolean isSessionReady(HttpServletRequest request);
    public void evaluarSesionActiva(HttpServletRequest request);
    public void establecerSesion(boolean is, HttpServletRequest request);
    
}

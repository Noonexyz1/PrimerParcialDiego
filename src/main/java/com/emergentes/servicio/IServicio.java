
package com.emergentes.servicio;

import com.emergentes.modelo.Calificacion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface IServicio {
    
    public List<Calificacion> listaCalificaciones(HttpServletRequest request);
    
    //para los Registros
    public void nuevoRegistroServicio(HttpServletRequest request);
    public Calificacion buscarRegistroServicio(int id);
    public void eliminarRegistroServicio(HttpServletRequest request);
    public void editarRegistroServicio(HttpServletRequest request);
    
    //para las Sesiones
    public boolean isSessionReadyServicio(HttpServletRequest request);
    public void evaluarSesionActivaServicio(HttpServletRequest request);
    public void establecerSesionServicio(boolean is, HttpServletRequest request);
    
}

package com.emergentes.servicio;

import com.emergentes.modelo.Calificacion;
import javax.servlet.http.HttpServletRequest;

public interface IRegistroManager {

    public void nuevoRegistro(HttpServletRequest request);
    public Calificacion buscarRegistro(int id);
    public void eliminarRegistro(HttpServletRequest request);
    public void editarRegistro(HttpServletRequest request);
    
    
    /*Si quiero que todas las sesiones que implementan esta interface,
    y para añadir una nueva fucnionalidad, solo debo agregarlo aqui, 
    y todos tendran que implementar esa nueva implementacion a su manera
    */

}

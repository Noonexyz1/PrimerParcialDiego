
package com.emergentes.servicio;

import javax.servlet.http.HttpServletRequest;

public interface ISesionManager {

    public void evaluarSesionActiva(HttpServletRequest request);
    public boolean isSessionReady(HttpServletRequest request) ;
    public void establecerSesion(boolean b, HttpServletRequest request);
    
    /*Si quiero que todas las sesiones que implementan esta interface,
    y para añadir una nueva fucnionalidad, solo debo agregarlo aqui, 
    y todos tendran que implementar esa nueva implementacion a su manera
    */
    
}

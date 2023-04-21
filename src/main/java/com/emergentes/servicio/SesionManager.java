
package com.emergentes.servicio;

import com.emergentes.modelo.SessionPersona;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SesionManager {
    
    public void evaluarSesionActiva(HttpServletRequest request) {
        //veluar si la session entrante esta vacia o no
        establecerSesion(isSessionReady(request), request);

    }

   
    public boolean isSessionReady(HttpServletRequest request) {
        if (request.getSession().isNew()) {
            return true;//por que no viene con un objeto session
        } else {
            return false; //si viene con objeto session establecida
        }

    }

    
    public void establecerSesion(boolean b, HttpServletRequest request) {
        if (b == true) {
            SessionPersona persona = new SessionPersona();
            persona.setId(100);
            persona.setNombre("Diego");
            persona.setNavegador("Firefox");

            HttpSession session = request.getSession();
            session.setAttribute("personasession", persona);

        }

    }
    
}

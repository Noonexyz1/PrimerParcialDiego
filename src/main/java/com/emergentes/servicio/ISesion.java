
package com.emergentes.servicio;

import javax.servlet.http.HttpServletRequest;

public interface ISesion {
    public boolean isSessionReadyServicio(HttpServletRequest request);
    public void evaluarSesionActivaServicio(HttpServletRequest request);
    public void establecerSesionServicio(boolean is, HttpServletRequest request);
}

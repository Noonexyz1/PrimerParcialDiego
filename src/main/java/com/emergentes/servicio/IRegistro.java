
package com.emergentes.servicio;

import com.emergentes.modelo.Calificacion;
import javax.servlet.http.HttpServletRequest;

public interface IRegistro {
    public void nuevoRegistroServicio(HttpServletRequest request);
    public Calificacion buscarRegistroServicio(int id);
    public void eliminarRegistroServicio(HttpServletRequest request);
    public void editarRegistroServicio(HttpServletRequest request);
}

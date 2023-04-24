
package com.emergentes.servicio;

import com.emergentes.modelo.Calificacion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface ICalificaciones {
    public List<Calificacion> listaCalificaciones(HttpServletRequest request);
}

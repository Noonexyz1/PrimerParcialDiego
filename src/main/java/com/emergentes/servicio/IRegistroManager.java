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
    
    /*
    Para Interface Segregation, las clases no deben estar obligadas a implementar una interfaz.
    Para ello, si quiero añadir una nueva implemetancion y vea que todas si o si necesariamiente
    deben de implementar una interfaz monolitica, pero al añadir una nueva funcionalidad
    lo que debo hacer es crearme una nueva interfaz y hacer que la clase que la necesite, implementarlo
    asi no habra problema alguno
    */

}

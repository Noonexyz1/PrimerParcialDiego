package com.emergentes.servicio;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.modelo.Calificacion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

//con I (Segregacion de interfaces) =)
//pero en los controllers deberia hacer Liskov para cada interfaceq que haga falta
//y para no joder mas el codigo, lo que hice es heredar todas esas interfaces a una sola
//llamada IServicio
//public class Servicio implements ICalificaciones, IRegistro, ISesion {
public class Servicio implements IServicio {

    //Inversion de dependencias
    //para ello nesecito un constructor para injectar desde afuera
    private ListaCalificacionesDatos calificaciones;

    private IRegistroManager iRegistroManager;
    private ISesionManager iSesionManager;

    public Servicio(ListaCalificacionesDatos calificaciones, IRegistroManager iRegistroManager, ISesionManager iSesionManager) {
        this.calificaciones = calificaciones;
        this.iRegistroManager = iRegistroManager;
        this.iSesionManager = iSesionManager;
    }
    
    public Servicio(ListaCalificacionesDatos calificaciones) {
        this.calificaciones = calificaciones;
    }

    
    
    @Override
    public List<Calificacion> listaCalificaciones(HttpServletRequest request) {
        //me creo una instancia de esta clase para acceder al atributo statico privado
        //que tiene esa clase

        if (request.getAttribute("listaCalificaciones") == null) {
            return calificaciones.getCalificacionesData();

        } else {
            return (List<Calificacion>) request.getAttribute("listaCalificaciones");

        }

    }

    @Override
    public void nuevoRegistroServicio(HttpServletRequest request) {
        //Sin Liskov
        //RegistroManager manager = new RegistroManager();
        //manager.nuevoRegistro(request);

        //Con Liskov
        //IRegistroManager manager = new RegistroManager();
        //manager.nuevoRegistro(request);
        //D
        iRegistroManager.nuevoRegistro(request);
    }

    @Override
    public Calificacion buscarRegistroServicio(int id) {
        //IRegistroManager manager = new RegistroManager();

        //D
        return iRegistroManager.buscarRegistro(id);
    }

    @Override
    public void eliminarRegistroServicio(HttpServletRequest request) {
        //IRegistroManager manager = new RegistroManager();
        //manager.eliminarRegistro(request);

        //D
        iRegistroManager.eliminarRegistro(request);
    }

    @Override
    public void editarRegistroServicio(HttpServletRequest request) {
        //IRegistroManager manager = new RegistroManager();
        //manager.editarRegistro(request);

        //D
        iRegistroManager.editarRegistro(request);
    }

    @Override
    public void evaluarSesionActivaServicio(HttpServletRequest request) {
        //ISesionManager sesion = new SesionManager();
        //sesion.evaluarSesionActiva(request);

        //D
        iSesionManager.evaluarSesionActiva(request);
    }

    @Override
    public boolean isSessionReadyServicio(HttpServletRequest request) {
        //ISesionManager sesion = new SesionManager();
        //return sesion.isSessionReady(request);

        //D
        return iSesionManager.isSessionReady(request);
    }

    @Override
    public void establecerSesionServicio(boolean b, HttpServletRequest request) {
        //ISesionManager sesion = new SesionManager();
        //sesion.establecerSesion(b, request);

        //D
        iSesionManager.establecerSesion(b, request);

    }

}

package com.emergentes.controller;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.modelo.Calificacion;
import com.emergentes.servicio.Servicio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.servicio.IServicio;
import com.emergentes.servicio.RegistroManager;
import com.emergentes.servicio.SesionManager;

@WebServlet(name = "PreInicio", urlPatterns = {"/"})
public class PreInicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Le puse Liskov sin saber que era liskov jajaja
        //IServicio servicio = new Servicio();
        
        //Injeccion de Dependencias
        //al hacer esto, algunos metodos no seran necesitados, asi que estaria injectando dependencias inecesarias
        //para arreglar ello, o bien lo establesco con sett o no hize bien la I de segregacion de interfaz (CREO QUE NO)
        //para ello, en la clase interface IServicio reemplazar por: public class Servicio implements ICalificaciones, IRegistro, ISesion { (CREO QUE NO)
        //o tambien, crear varios constructores que por parametro solo me mande una dependencia que nesecite, sobrecarga de constructor
        
        IServicio servicio = new Servicio(
                new ListaCalificacionesDatos(),
                new RegistroManager(),
                new SesionManager()
        );
        
        
        //IServicio servicio2 = new Servicio(new ListaCalificacionesDatos()); necesito en SesionManager si o si

        //añadimos una session object y está presente en todo el programa
        /*
        Cada navegador crea su propio conjunto de cookies, y por lo tanto cada uno tendrá su propia sesión de HttpSession independiente en el servidor.
        Cuando un usuario abre una aplicación web en un navegador por primera vez, el servidor crea una nueva sesión de HttpSession para ese usuario 
        y le asigna un ID de sesión único. Este ID se almacena en una cookie en el navegador del usuario y se envía al servidor con cada solicitud posterior.
        Si el usuario abre la misma aplicación web en otro navegador, el servidor creará una nueva sesión de HttpSession para ese 
        navegador y le asignará un ID de sesión diferente. Por lo tanto, la información almacenada en la sesión de HttpSession no se compartirá entre 
        diferentes navegadores o dispositivos.
         */
        
        servicio.evaluarSesionActivaServicio(request);
        //servicio2.evaluarSesionActivaServicio(request); ESTO ES LO QUE NECESITO necesito en SesionManager si o si
        //asi que este codigo anterior necesita dos dependencias de la cual solo envie una, eso me daba error, puedo arreglarlo de varias formas jaja =)
        
        List<Calificacion> lista = servicio.listaCalificaciones(request);

        request.setAttribute("listaCalificaciones", lista);
        //ME PARACE QUE TODO ESTA YENDO AL INDEX!!!!!!!!!
        request.getRequestDispatcher("inicio.jsp").forward(request, response);
        //request.getRequestDispatcher("/PostInicio").forward(request, response);

        /*
	 * NOTA MUY IMPORTANTE
	 * Cuando se tiene un servlet con / en la anotacion de la cabeza de la clase,
	 * y despues tienes un index.jsp dentro de ese /
	 * lo primero que hara sera siempre llamar al index.jsp
	 * ya que / solo es la ruta principal, entonces en la ruta principal, el servidor,
	 * solamente ejecutara el primer index.jsp que encuentre
	 * (lo que hize era que cambie de nombre el index.jsp ahora todo va genial)
	 * era como si le volviera a repetir que desde / vaya al index.jsp cuando eso era lo que hacia por dentro
	 * 
	 * EL INDEX.JSP TIENE MAS PRIORIDAD que /
	 * cuando el servidor vea que no hay un index entoces recien hace caso al /
	 * 
	 * Al momento de iniciar el servidor, el servidor lo primero que hace es ver donde esta el index
	 * si no lo encuentra, entonce recien consulta por los servlets, en mi caso, recien hara caso al / con el jsp
	 * que tengo programado para despachar.
	 * 
	 * Hay una forma de establecer un /nombre como principal con el descriptor
	 * 
	* */
    }

}

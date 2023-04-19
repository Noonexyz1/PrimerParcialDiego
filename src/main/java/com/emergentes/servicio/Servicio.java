package com.emergentes.servicio;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.modelo.Calificacion;
import com.emergentes.modelo.SessionPersona;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Servicio implements InterfaceServicio {
	
    @Override
    public List<Calificacion> listaCalificaciones(HttpServletRequest request) {
        //me creo una instancia de esta clase para acceder al atributo statico privado
        //que tiene esa clase
    	
    	
    	if (request.getAttribute("listaCalificaciones") == null) {
    		return new ListaCalificacionesDatos().getCalificacionesData();
    		
		} else {
			
			return (List<Calificacion>) request.getAttribute("listaCalificaciones");
			
		}
    	
        
    }
    
    

    @Override
    public void nuevoRegistro(HttpServletRequest request) {
    
    	ListaCalificacionesDatos listaCalificacionesDatos = new ListaCalificacionesDatos();
    	
        Calificacion cal = new Calificacion();
        
        cal.setId(listaCalificacionesDatos.getId());
        listaCalificacionesDatos.setId(listaCalificacionesDatos.getId() + 1);
        
        cal.setNombre(request.getParameter("nombres"));
        
        int nota1, nota2, notaFinal, notaF;
        nota1 = Integer.parseInt(request.getParameter("parcialUno"));
        nota2 = Integer.parseInt(request.getParameter("parcialDos"));
        notaFinal = Integer.parseInt(request.getParameter("parcialTres"));
        notaF = nota1 + nota2 + notaFinal;
        
        cal.setP1(nota1);
        cal.setP2(nota2);
        cal.setEf(notaFinal);
        
        cal.setNota(notaF);
        
        listaCalificacionesDatos.getCalificacionesData().add(cal);
        
    }

    @Override
    public Calificacion buscarRegistro(int id) {
    	Calificacion cal = null;
    	
    	List<Calificacion> calificaciones = new ListaCalificacionesDatos().getCalificacionesData();
    	
    	for (Calificacion cali: calificaciones) {
			if (cali.getId() == id) {
				cal = cali;
			}
		}
    	
    	return cal;
    	
    	
    	
    	
    	
    	
    }



	@Override
	public void eliminarRegistro(HttpServletRequest request) {
		//buscar el registro con el id
		//buscarRegistro(Integer.parseInt(request.getParameter("id")));
		//buscarRegistro(0);
		new ListaCalificacionesDatos().getCalificacionesData().remove(buscarRegistro(Integer.parseInt(request.getParameter("id"))));
		
	}



	@Override
	public void editarRegistro(HttpServletRequest request) {
		Calificacion cal = new Calificacion();
        cal.setId(Integer.parseInt(request.getParameter("id")));
        cal.setNombre(request.getParameter("nombres"));
        
        int nota1, nota2, notaFinal, notaF;
        nota1 = Integer.parseInt(request.getParameter("parcialUno"));
        nota2 = Integer.parseInt(request.getParameter("parcialDos"));
        notaFinal = Integer.parseInt(request.getParameter("parcialTres"));
        notaF = nota1 + nota2 + notaFinal;
        
        cal.setP1(nota1);
        cal.setP2(nota2);
        cal.setEf(notaFinal);
        
        cal.setNota(notaF);
        
        List<Calificacion> lista = new ListaCalificacionesDatos().getCalificacionesData();
        int indice = lista.indexOf(buscarRegistro(Integer.parseInt(request.getParameter("id"))));
        
        lista.set(indice, cal);
		
	}



	



	@Override
	public void evaluarSesionActiva(HttpServletRequest request) {
		//veluar si la session entrante esta vacia o no
		establecerSesion(isSessionReady(request), request);
		
	}


	@Override
	public boolean isSessionReady(HttpServletRequest request) {
		if (request.getSession().isNew()) {
			return true;//por que no viene con un objeto session
		} else {
			return false; //si viene con objeto session establecida
		}
		
	}
	

	@Override
	public void establecerSesion(boolean b, HttpServletRequest request) {
		if (b == true) {
			SessionPersona persona = new SessionPersona();
			persona.setId(100);
			persona.setNombre("Carlos");
			persona.setNavegador("Firefox");
			
			HttpSession session = request.getSession();
			session.setAttribute("personasession", persona);
			
		}
		
	}





}

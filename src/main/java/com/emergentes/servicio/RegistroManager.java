
package com.emergentes.servicio;

import com.emergentes.datos.ListaCalificacionesDatos;
import com.emergentes.modelo.Calificacion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class RegistroManager {

 
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

        //validacion numeros menores o iguales a 30
        if ((nota1 <= 30) && (nota2 <= 30) && (notaFinal <= 40)) {
            cal.setP1(nota1);
            cal.setP2(nota2);
            cal.setEf(notaFinal);

            cal.setNota(notaF);

            listaCalificacionesDatos.getCalificacionesData().add(cal);
        } 
        
        //si no cumple esa condicion, entonces simplemente lo redirige pero sin los datos
    
    }
    

    public Calificacion buscarRegistro(int id) {
        Calificacion cal = null;

        List<Calificacion> calificaciones = new ListaCalificacionesDatos().getCalificacionesData();

        for (Calificacion cali : calificaciones) {
            if (cali.getId() == id) {
                cal = cali;
            }
        }

        return cal;

    }


    public void eliminarRegistro(HttpServletRequest request) {
        //buscar el registro con el id
        //buscarRegistro(Integer.parseInt(request.getParameter("id")));
        //buscarRegistro(0);
        new ListaCalificacionesDatos().getCalificacionesData().remove(buscarRegistro(Integer.parseInt(request.getParameter("id"))));

    }

  
    public void editarRegistro(HttpServletRequest request) {
        Calificacion cal = new Calificacion();
        cal.setId(Integer.parseInt(request.getParameter("id")));
        cal.setNombre(request.getParameter("nombres"));

        int nota1, nota2, notaFinal, notaF;
        nota1 = Integer.parseInt(request.getParameter("parcialUno"));
        nota2 = Integer.parseInt(request.getParameter("parcialDos"));
        notaFinal = Integer.parseInt(request.getParameter("parcialTres"));
        notaF = nota1 + nota2 + notaFinal;

        
        //validacion numeros menores o iguales a 30
        if ((nota1 <= 30) && (nota2 <= 30) && (notaFinal <= 40)) {

            cal.setP1(nota1);
            cal.setP2(nota2);
            cal.setEf(notaFinal);

            cal.setNota(notaF);

            List<Calificacion> lista = new ListaCalificacionesDatos().getCalificacionesData();
            int indice = lista.indexOf(buscarRegistro(Integer.parseInt(request.getParameter("id"))));

            lista.set(indice, cal);

        }
        
        //si no cumple esa condicion, entonces simplemente lo redirige pero sin los datos
        
    }
    
}

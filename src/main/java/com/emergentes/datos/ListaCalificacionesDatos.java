
package com.emergentes.datos;

import com.emergentes.modelo.Calificacion;

import java.util.ArrayList;
import java.util.List;

public class ListaCalificacionesDatos {
    
	//una clase generica debe ser instanciada si o si de la siguiente manera
    private static ArrayList<Calificacion> calificacionesData = new ArrayList<>();
    //private static ArrayList<Calificaciones> calificacionesData;
    private static int id = 1;
    


	public ListaCalificacionesDatos(){
        //todos los valores de los atributos se inicializan en null;
        //a no ser que se inicialize directamente en los atributos
        //en dado caso, entonces el constructor creara la instancia con esos valores
    	
    	
    	//calificacionesData = new ArrayList<>();
    	
    }
    

    
    //Aqui mis metodos son estaticos, esto solo para probar que pasará
    //no puedo jalar este metodo, por lo tanto quitare el static, porque no es una instancia
    public List<Calificacion> getCalificacionesData() {
        return calificacionesData;
    }
    
    public void setCalificacionesData(List<Calificacion> calificacionesData) {
    	ListaCalificacionesDatos.calificacionesData = (ArrayList<Calificacion>) calificacionesData;
    }
    
    
    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
   
    
}

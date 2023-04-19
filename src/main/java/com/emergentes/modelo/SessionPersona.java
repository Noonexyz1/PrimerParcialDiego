package com.emergentes.modelo;

import java.io.Serializable;

public class SessionPersona implements Serializable{
	private int id;
	private String nombre;
	private String navegador;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNavegador() {
		return navegador;
	}
	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}
	
	
	
	
}

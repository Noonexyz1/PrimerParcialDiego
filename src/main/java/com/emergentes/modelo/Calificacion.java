package com.emergentes.modelo;

public class Calificacion {

    private int id;
    private String nombre;
    private int p1;
    private int p2;
    private int ef;
    private int Nota;

    
    public Calificacion() {
    }

    public Calificacion(int id, String nombre, int p1, int p2, int ef, int nota) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.p1 = p1;
        this.p2 = p2;
        this.ef = ef;
        Nota = nota;
    }

    
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

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getEf() {
        return ef;
    }

    public void setEf(int ef) {
        this.ef = ef;
    }

    public int getNota() {
        return Nota;
    }

    public void setNota(int nota) {
        Nota = nota;
    }

}

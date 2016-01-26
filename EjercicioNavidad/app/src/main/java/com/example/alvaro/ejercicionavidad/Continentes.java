package com.example.alvaro.ejercicionavidad;


import java.io.Serializable;

/**
 * Created by alvaro on 25/01/16.
 */

public class Continentes implements Serializable {
    private int id;
    private String nombre;
    private int imagen;
    private int zona;
    private int precio;

    //Constructor
    public Continentes(int id, String nombre, int zona, int precio,int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.zona = zona;
        this.precio = precio;
        this.imagen = imagen;
    }
    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public int getZona() {
        return zona;
    }

    public int getPrecio() {
        return precio;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}

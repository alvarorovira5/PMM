package com.example.alvaro.ejercicionavidad;

/**
 * Created by alvaro on 17/02/16.
 */
public class todosPedidos {
    private int id_Pedidos;
    private String zona, nombre;
    private float precio;
    private int id_Cliente;


    public todosPedidos() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public todosPedidos(int id_Pedidos, float precio, String zona, String nombre, int id_Cliente) {
        this.nombre=nombre;

        this.id_Pedidos = id_Pedidos;
        this.precio = precio;
        this.zona = zona;
        this.id_Cliente = id_Cliente;
    }

    public int getId_Pedidos() {
        return id_Pedidos;
    }

    public void setId_Pedidos(int id_Pedidos) {
        this.id_Pedidos = id_Pedidos;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
}

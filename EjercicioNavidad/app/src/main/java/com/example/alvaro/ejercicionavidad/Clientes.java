package com.example.alvaro.ejercicionavidad;

/**
 * Created by alvaro on 4/02/16.
 */
public class Clientes {
    private  int id_Cliente;
    private String nombre;
    private String apellidos;
    private String direccion;
    private int telefono;

    public Clientes() {

    }
    public Clientes(int id_Cliente, String nombre, String apellidos, String direccion, int telefono) {
        this.id_Cliente = id_Cliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

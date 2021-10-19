package com.example.comprasapp.model;


import androidx.room.Ignore;

import java.util.Date;

public class Compra {

    private int id;

    private String nombre;

    private int precio;

    private int cantidad;

    private int total;

    private Date fecha;


    public Compra(int id, String nombre, int precio, int cantidad, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = this.precio * this.cantidad;
        this.fecha = fecha;
    }

    @Ignore
    public Compra(String nombre, int precio, int cantidad,  Date fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = this.precio * this.cantidad;
        this.fecha = fecha;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.app.recursos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rdurante
 */

@XmlRootElement
public class Producto {

    private long id;
    private String nombre;
    private double precio;
    private boolean activo;

    public Producto() {
    }

    
    public Producto(long id, String nombre, double precio, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.activo = activo;
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}

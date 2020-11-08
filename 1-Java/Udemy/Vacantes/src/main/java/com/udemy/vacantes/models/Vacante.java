
package com.udemy.vacantes.models;

import java.util.Date;
import lombok.Data;

@Data
public class Vacante {
    
    private Long id;
    private Date fechaPublicacion;
    private String nombre;
    private String descripcion;
    private String detalle;

    public Vacante() {
        fechaPublicacion = new Date();
    }

    public Vacante(Long id) {
        this.id = id;
    }

    public Vacante(String nombre, String descripcion, String detalle) {
        fechaPublicacion = new Date();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.detalle = detalle;
    }
    
    @Override
    public String toString(){
        return "Id: " + id + " - Fecha: " + fechaPublicacion + "- Nombre: " + nombre
                + "- Descripción: " + descripcion;
    }
}

package com.udemy.vacantes.models;

import java.util.Date;
import lombok.Data;

@Data
public class Solicitud {

    private Long id;
    private Date fecha;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String archivo;
    private Vacante vacante;

    public Solicitud() {
    }
    
    

    public Solicitud(Long id) {
        this.id = id;
    }
}

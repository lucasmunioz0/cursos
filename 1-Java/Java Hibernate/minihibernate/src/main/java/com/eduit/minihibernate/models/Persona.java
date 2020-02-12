package com.eduit.minihibernate.models;

import com.eduit.minihibernate.interfaces.PK;
import com.eduit.minihibernate.interfaces.Tabla;

@Tabla( nombre = "personas")
public class Persona {
    
    @PK
    private Long id;

    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + '}';
    }
}
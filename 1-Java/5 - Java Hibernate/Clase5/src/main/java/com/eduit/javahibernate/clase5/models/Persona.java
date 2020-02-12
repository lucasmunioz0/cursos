package com.eduit.javahibernate.clase5.models;

import javax.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    private Legajo legajo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Legajo getLegajo() {
        return legajo;
    }

    public void setLegajo(Legajo legajo) {
        this.legajo = legajo;
    }
}

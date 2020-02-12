package com.eduit.javahibernate.laboratorio.model;

import javax.persistence.*;

@Entity
@Table(name = "empresas")
public class Concesionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id")
    private Long id;
    @Column(name = "em_nombre")
    private String nombre;
    @Column(name = "em_direccion")
    private String direccion;

    public Concesionario() {
    }

    public Concesionario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format("%d %s (%s)", id, nombre, direccion);
    }
}

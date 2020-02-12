package com.ar.eduit.javahibernate.clase3.entities;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id")
    private Long id;
    @Column(name = "cl_nombre")
    private String nombre;
    @Column(name = "cl_apellido")
    private String apellido;
    @Column(name = "cl_credito")
    private Double credito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, Double credito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.credito = credito;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", credito=" + credito +
                '}';
    }
}

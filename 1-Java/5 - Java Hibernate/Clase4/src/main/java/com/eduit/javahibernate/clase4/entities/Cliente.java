package com.eduit.javahibernate.clase4.entities;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name = "cl_id")
public class Cliente extends Persona {
    @Column(name = "cl_credito")
    private Double credito;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, Double credito) {
        super(nombre, apellido);
        this.credito = credito;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return super.toString() + " Cliente{" +
                "credito=" + credito +
                '}';
    }
}

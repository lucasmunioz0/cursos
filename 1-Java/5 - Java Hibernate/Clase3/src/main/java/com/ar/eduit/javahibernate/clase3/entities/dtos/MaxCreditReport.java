package com.ar.eduit.javahibernate.clase3.entities.dtos;

public class MaxCreditReport {
    private String nombre;
    private Double credito;

    public MaxCreditReport(String nombre, Double credito) {
        this.nombre = nombre;
        this.credito = credito;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getCredito() {
        return credito;
    }

    @Override
    public String toString() {
        return "MaxCreditReport{" +
                "nombre='" + nombre + '\'' +
                ", credito=" + credito +
                '}';
    }
}

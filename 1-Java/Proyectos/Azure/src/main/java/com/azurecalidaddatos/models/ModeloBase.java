/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class ModeloBase {
    private BigDecimal id;
    private String nombre;

    public ModeloBase() {
    }

    public ModeloBase(BigDecimal id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ModeloBase(BigDecimal id) {
        this.id = id;
    }

    public ModeloBase(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%s - Id: %d, Nombre: %s", this.getClass().getSimpleName(), id, nombre);
    }
}
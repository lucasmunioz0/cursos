package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class SistemaOrigen extends ModeloBase{

    public SistemaOrigen() {
        super();
    }

    public SistemaOrigen(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public SistemaOrigen(BigDecimal id) {
        this(id, null);
    }

    public SistemaOrigen(String nombre) {
        this(null, nombre);
    }
}
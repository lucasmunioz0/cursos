package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class EstadoIncidente extends ModeloBase{

    public EstadoIncidente() {
        super();
    }

    public EstadoIncidente(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public EstadoIncidente(BigDecimal id) {
        this(id, null);
    }

    public EstadoIncidente(String nombre) {
        this(null, nombre);
    }
}
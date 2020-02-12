package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class DescripcionIncidente extends ModeloBase{

    public DescripcionIncidente() {
        super();
    }

    public DescripcionIncidente(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public DescripcionIncidente(BigDecimal id) {
        this(id, null);
    }

    public DescripcionIncidente(String nombre) {
        this(null, nombre);
    }
}
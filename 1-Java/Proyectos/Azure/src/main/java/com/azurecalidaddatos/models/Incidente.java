package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class Incidente extends ModeloBase{

    public Incidente() {
        super();
    }

    public Incidente(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public Incidente(BigDecimal id) {
        this(id, null);
    }

    public Incidente(String nombre) {
        this(null, nombre);
    }
}
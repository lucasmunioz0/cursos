package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class Informador extends ModeloBase{

    public Informador() {
        super();
    }

    public Informador(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public Informador(BigDecimal id) {
        this(id, null);
    }

    public Informador(String nombre) {
        this(null, nombre);
    }
}
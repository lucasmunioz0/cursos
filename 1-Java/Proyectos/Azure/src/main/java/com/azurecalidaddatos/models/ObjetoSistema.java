package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class ObjetoSistema extends ModeloBase{

    public ObjetoSistema() {
        super();
    }

    public ObjetoSistema(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public ObjetoSistema(BigDecimal id) {
        this(id, null);
    }

    public ObjetoSistema(String nombre) {
        this(null, nombre);
    }
}
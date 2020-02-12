package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class CausaIncidente extends ModeloBase{

    public CausaIncidente() {
        super();
    }

    public CausaIncidente(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public CausaIncidente(BigDecimal id) {
        this(id, null);
    }

    public CausaIncidente(String nombre) {
        this(null, nombre);
    }
}
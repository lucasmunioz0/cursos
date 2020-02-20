package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class SucesoIncidente extends ModeloBase{

    public SucesoIncidente() {
        super();
    }

    public SucesoIncidente(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public SucesoIncidente(BigDecimal id) {
        this(id, null);
    }

    public SucesoIncidente(String nombre) {
        this(null, nombre);
    }
}
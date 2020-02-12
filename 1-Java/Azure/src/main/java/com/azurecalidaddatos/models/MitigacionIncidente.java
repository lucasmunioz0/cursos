package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class MitigacionIncidente extends ModeloBase{

    public MitigacionIncidente() {
        super();
    }

    public MitigacionIncidente(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public MitigacionIncidente(BigDecimal id) {
        this(id, null);
    }

    public MitigacionIncidente(String nombre) {
        this(null, nombre);
    }
}
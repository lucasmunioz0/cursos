package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class TipoIncidente extends ModeloBase{

    public TipoIncidente(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public TipoIncidente(BigDecimal id) {
        super(id);
    }

    public TipoIncidente(String nombre) {
        super(nombre);
    }

    public TipoIncidente() {
    }    
}
package com.azurecalidaddatos.models;

import java.math.BigDecimal;

public class TicketDerivado extends ModeloBase{

    public TicketDerivado() {
        super();
    }

    public TicketDerivado(BigDecimal id, String nombre) {
        super(id, nombre);
    }

    public TicketDerivado(BigDecimal id) {
        this(id, null);
    }

    public TicketDerivado(String nombre) {
        this(null, nombre);
    }
}
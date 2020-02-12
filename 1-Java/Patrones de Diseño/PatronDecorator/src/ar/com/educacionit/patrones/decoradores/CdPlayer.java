package ar.com.educacionit.patrones.decoradores;

import ar.com.educacionit.patrones.interfaces.Vendible;

public class CdPlayer extends AutoDecorator {

    public CdPlayer(Vendible vendible) {
        super(vendible);
    }

    @Override
    public String getDescripcion() {
        return getVendible().getDescripcion() + " + CD Player";
    }

    @Override
    public int getPrecio() {
        return getVendible().getPrecio() + 100;
    }
}
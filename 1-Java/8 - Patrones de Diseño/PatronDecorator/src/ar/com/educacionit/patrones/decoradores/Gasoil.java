package ar.com.educacionit.patrones.decoradores;

import ar.com.educacionit.patrones.interfaces.Vendible;

public class Gasoil extends AutoDecorator {

    public Gasoil(Vendible vendible) {
        super(vendible);
    }

    @Override
    public String getDescripcion() {
        return getVendible().getDescripcion() + " + Gasoil";
    }

    @Override
    public int getPrecio() {
        return getVendible().getPrecio() + 1200;
    }
}
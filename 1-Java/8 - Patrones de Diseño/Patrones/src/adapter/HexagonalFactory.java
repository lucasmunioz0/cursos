/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adapter;


public class HexagonalFactory implements AbstractFactory {

    public HexagonalFactory() {
    }

    @Override
    public Boton createBoton() {
        BotonHexagonal boton = new BotonHexagonal();
        return new BotonHexagonalAdapter(boton);
    }

    @Override
    public CajaDeTexto createCajaDeTexto() {
        return new CajaDeTextoHexagonalAdapter();
    }

}

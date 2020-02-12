/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adapter;


public class BotonHexagonalAdapter implements Boton{

    private BotonHexagonal boton;
    
    public BotonHexagonalAdapter(BotonHexagonal boton) {
        this.boton = boton;
    }

    @Override
    public void click() {
        new BotonHexagonal().doClick("");
    }

}

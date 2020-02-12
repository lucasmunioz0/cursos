/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstractFactory;


public class RectagularFactory implements AbstractFactory{    
    
    @Override
    public BotonRectangular createBoton(){
        return new BotonRectangular();
    }
    
    @Override
    public CajaDeTextoRectangular createCajaDeTexto(){
        return new CajaDeTextoRectangular();
    }
}

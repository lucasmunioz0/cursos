/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstractFactory;


public class CircularFactory implements AbstractFactory{
    
    @Override
    public BotonCircular createBoton(){
        return new BotonCircular();
    }
    
    @Override
    public CajaDeTextoCircular createCajaDeTexto(){
        return new CajaDeTextoCircular();
    }
}

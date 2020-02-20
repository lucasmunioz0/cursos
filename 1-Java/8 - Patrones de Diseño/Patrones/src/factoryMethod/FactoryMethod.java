/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factoryMethod;


public class FactoryMethod {
    public static Boton createBoton(){
        return new BotonRectangular();
    }
    
    public static CajaDeTexto createCajaDeTexto(){
        return new CajaDeTextoRectangular();
    }
}

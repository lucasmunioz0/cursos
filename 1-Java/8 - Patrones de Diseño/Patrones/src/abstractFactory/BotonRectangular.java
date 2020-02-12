/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

public class BotonRectangular implements Boton {

    @Override
    public void click() {
        System.out.println("Se hizo click en el botón rectangular.");
    }
}

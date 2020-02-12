/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adapter;


public class CajaDeTextoHexagonalAdapter implements CajaDeTexto{

    @Override
    public void dibujar() {
        new CajaDeTextoHexagonal().draw(0);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;


public abstract class Autorizante {
    
    protected Autorizante next;

    protected Autorizante(Autorizante next) {
        this.next = next;
    }
    
    public abstract String autorizar(float monto);
}

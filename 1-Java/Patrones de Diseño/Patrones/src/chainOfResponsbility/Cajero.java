/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;


public class Cajero extends Autorizante{

    public Cajero(Autorizante next) {
        super(next);
    }    

    @Override
    public String autorizar(float monto) {
        if(monto <= 20000){
            System.out.println("Autorizado por cajero.");
            return "Autorizado.";
        }
        return next.autorizar(monto);
    }

}

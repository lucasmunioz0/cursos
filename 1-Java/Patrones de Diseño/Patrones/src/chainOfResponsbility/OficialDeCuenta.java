/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;


public class OficialDeCuenta extends Autorizante{

    public OficialDeCuenta(Autorizante next) {
        super(next);
    }
    
    @Override
    public String autorizar(float monto) {
        if(monto > 20000 && monto <= 150000){
            System.out.println("Autorizado por Oficial de Cuenta.");
            return "Autorizado.";
        }
        return next.autorizar(monto);
    }

}

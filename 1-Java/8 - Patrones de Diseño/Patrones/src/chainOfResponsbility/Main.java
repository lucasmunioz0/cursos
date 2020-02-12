/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainOfResponsbility;


public class Main {
    public static void main(String[] args) {
        float monto = 151000;
        
        
        Autorizante gerente = new Gerente(null);
        Autorizante oficialCuenta = new OficialDeCuenta(gerente);
        Autorizante cajero = new Cajero(oficialCuenta);
        
        String resultado = cajero.autorizar(monto);
        System.out.println(resultado);
    }
}

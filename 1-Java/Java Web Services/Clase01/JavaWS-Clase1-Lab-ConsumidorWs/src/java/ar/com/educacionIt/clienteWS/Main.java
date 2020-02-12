/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionIt.clienteWS;

import ar.com.educacionit.productor.MiPrimerWS_Service;

/**
 *
 * @author Vane
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String respuesta = new MiPrimerWS_Service().getMiPrimerWSPort().hola("Hola mundo! ");
        System.out.println(respuesta);
    }
    
}

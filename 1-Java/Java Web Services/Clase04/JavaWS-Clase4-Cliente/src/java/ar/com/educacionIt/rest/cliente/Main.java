/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionIt.rest.cliente;

/**
 *
 * @author Vane
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MiCliente mi = new MiCliente();
        System.out.println(mi.getNombreXml("hola"));
    }
    
}

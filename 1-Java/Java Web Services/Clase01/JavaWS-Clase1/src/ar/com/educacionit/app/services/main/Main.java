/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.app.services.main;

import ar.com.educacionit.app.services.ServicioInicial;
import javax.xml.ws.Endpoint;

/**
 *
 * @author rdurante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Iniciando servicio");
        Endpoint.publish("http://127.0.0.1:9001/ws/MiServicio", new ServicioInicial());
        System.out.println("Servicio Iniciado");        
        
    }
    
}

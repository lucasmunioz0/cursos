/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.app.services;

import javax.jws.WebService;

/**
 *
 * @author rdurante
 */
@WebService
public class ServicioInicial {

    public String holaMundo() {
        return "Hola Mundo";
    }
    
    public Boolean sosMayor(int edad){
        return edad >17;
    }
    
}

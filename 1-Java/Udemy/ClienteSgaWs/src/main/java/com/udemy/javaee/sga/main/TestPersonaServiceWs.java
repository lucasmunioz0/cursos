/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.javaee.sga.main;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServicesWS;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class TestPersonaServiceWs {
    public static void main(String[] args) {
        PersonaServicesWS personaServices = new PersonaServiceImplService().getPersonaServiceImplPort();
        List<Persona> listarPersonas = personaServices.listarPersonas();
        
        listarPersonas.stream().forEach(persona -> {
            System.out.println("Id: " + persona.getIdPersona() + " - " + persona.getNombre() + ", " + persona.getApellido() + " - " + persona.getEmail());
        });
    }
}

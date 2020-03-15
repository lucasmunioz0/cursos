package com.udemy.javaee.sga;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import javax.naming.*;

public class ClientePersonaService {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando llamada al EJB desde el cliente");
            
            String authFile = "login.conf";
            System.setProperty("java.security.auth.login.config", authFile);
            ProgrammaticLogin login = new ProgrammaticLogin();
            login.login("admin", "admin".toCharArray());
            
            Context jdni = new InitialContext();
            
            PersonaServiceRemote personaServiceRemote = (PersonaServiceRemote) jdni.lookup("java:global/sga-webjsf/PersonaServiceImpl!com.udemy.sga.services.PersonaService");
            List<Persona> personas = personaServiceRemote.findAll();
            
            personas.stream().forEach(System.out::println);
        } catch (NamingException ex) {
            
        }
    }
}

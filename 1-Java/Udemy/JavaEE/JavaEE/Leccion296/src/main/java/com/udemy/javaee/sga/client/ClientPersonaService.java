package com.udemy.javaee.sga.client;

import com.udemy.javaee.sga.domain.Persona;
import com.udemy.javaee.sga.service.PersonaServiceRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientPersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamda al EJB desde el cliente\n");
        try{
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/Leccion296/PersonaServiceImpl!com.udemy.javaee.sga.service.PersonaServiceRemote");
            final List<Persona> people = personaService.getAll();
            people.forEach(System.out::println);
        }catch(NamingException e){
            e.printStackTrace(System.err);
        }
    }
}

package com.udemy.javaee.sga.clientesgarestws;

import com.udemy.javaee.sga.domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;


public class TestPersonaServicesRS {
    private static final String URL_BASE = "http://localhost:8080/sga-webrest/webservices";
    private static Client client;
    private static WebTarget target;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        client = ClientBuilder.newClient();      
        
        target = client.target(URL_BASE + "/personas");
        
        
        persona = target.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("\t1. Persona con Id 2: " + persona);
        
        System.out.println("\t2. Todas las personas: ");
        personas = target.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        imprimirPersonas(personas);
        
        System.out.println("\t3. Agregar persona: ");
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Carlos");
        nuevaPersona.setApellido("Muñoz");
        nuevaPersona.setEmail("cmunasdoz@mail.com");
        nuevaPersona.setTelefono("43731645");
        invocationBuilder = target.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Estado de petición: " + response.getStatus());
        System.out.println("Persona recien agregada: " + personaRecuperada);
        
        System.out.println("\t4. Modificar persona: ");
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Ramirez");
        String pathId = "/" + personaModificar.getIdPersona();
        invocationBuilder = target.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        System.out.println("Status: " + response.getStatus());
        System.out.println("Persona Modificada: " + response.readEntity(Persona.class));
        
        personas = target.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        imprimirPersonas(personas);
        
        Persona personaEliminar = personaRecuperada;
        pathId = "/" + personaEliminar.getIdPersona();
        invocationBuilder = target.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("Status: " + response.getStatus());
        System.out.println("Persona eliminada: " + personaEliminar);
        
        personas = target.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        imprimirPersonas(personas);
        
    }
    
    private static void imprimirPersonas(List<Persona> personas){
        personas.stream().forEach(System.out::println);
    }
}

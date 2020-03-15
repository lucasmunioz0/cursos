package com.udemy.javaee.sga;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ClientePersonaService {
    public static void main(String[] args) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        ClientConfig config = new ClientConfig();
        config.register(feature);
        
        Client cliente = ClientBuilder.newClient(config);
        
        WebTarget webTarget = cliente.target("http://localhost:8080/sga-websecurity").path("/personas");
        Persona persona = webTarget.path("/2").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada:" + persona);
    }
}

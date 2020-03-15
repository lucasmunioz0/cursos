/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.sga.services;

import com.udemy.sga.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Lucas
 */
@Path("/personas")
@Stateless
public class PersonaServiceRs {

    @Inject
    private PersonaService personaService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> listarPersonas() {
        return personaService.findAll();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Persona findById(@PathParam("id") Integer id) {
        return personaService.getById(new Persona(id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response insertPersona(Persona persona) {
        try {
            personaService.insert(persona);
            return Response.ok().entity(persona).build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    } 

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response updatePersona(@PathParam("id") Integer id, Persona personaModificada) {
        try {
            Persona persona = personaService.getById(new Persona(id));
            if (persona != null) {
                personaService.update(personaModificada);
                return Response.ok().entity(persona).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletePersona(@PathParam("id") Integer id) {
        try {
            personaService.delete(new Persona(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}

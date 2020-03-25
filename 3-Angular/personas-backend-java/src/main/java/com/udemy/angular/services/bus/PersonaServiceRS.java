package com.udemy.angular.services.bus;

import com.udemy.angular.dal.dao.PersonaDao;
import com.udemy.angular.domains.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/personas")
public class PersonaServiceRS {

    @Inject
    private PersonaDao dao;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Persona> listarPersonas() {
        final List<Persona> findAll = dao.findAll();
        System.out.println("Personas encontradas: " + findAll);
        return findAll;
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Persona getPersonaById(@PathParam("id") Long id) {
        final Persona find = dao.findById(new Persona(id));
        System.out.println("Persona encontrada: " + find);
        return find;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Persona insertPersona(Persona persona) {
        dao.insert(persona);
        System.out.println("Persona agregada: " + persona);
        return persona;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updatePersona(@PathParam("id") Long id, Persona persona) {
        final Persona aModificar = dao.findById(new Persona(id));

        if (aModificar != null) {
            dao.update(persona);
            System.out.println("Persona modificada: " + persona);
            return Response.ok().entity(persona).build();
        }else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces (value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response delete (@PathParam("id") Long id){
        final Persona persona = dao.findById(new Persona(id));
        if(persona != null){
            dao.delete(persona);
            return Response.ok("Persona eliminada correctamente").build();
        }else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}

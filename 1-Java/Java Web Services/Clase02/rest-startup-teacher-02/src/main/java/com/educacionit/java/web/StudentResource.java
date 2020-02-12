package com.educacionit.java.web;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentResource {
    private StudentDAO dao = new StudentDAO();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll(){
        return Response.status(200).entity(dao.findAll()).build();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findById(@PathParam("id") String id){
        return Response.status(200).entity(dao.findById(Integer.parseInt(id))).build();
    }
    
    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByName(@PathParam("name") String name){
        return Response.status(200).entity(dao.findByName(name)).build();
    }
}

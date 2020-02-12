package com.educacionit.java.web;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employees") //Indica que es un servicio
public class EmployeeResource {

    EmployeeDAO dao = new EmployeeDAO();

    public EmployeeResource() {
        super();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON}) //Indica que produce un tipo de Dato, en este caso JSON 
    public Response findAll() {
        return Response.status(200).entity(this.dao.findAll()).build(); //El entity indica lo que estoy devolviendo y luego lo construye. en pocas palabra, el entity setea el body.
    }

    @GET
    @Path("{id}") //Extrae el valor de la url lo que le sigue al endpoint.
    @Produces({MediaType.APPLICATION_JSON}) 
    public Response findById(@PathParam("id") String id) { //Con el pathparam indica el match que debe hacer el "id" del parametro con el path
        return Response.status(200).entity(this.dao.findById(Integer.parseInt(id))).build();
    }

    @GET
    @Path("{id}/reports")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByManager(@PathParam("id") String managerId) {
        return Response.status(200).entity(this.dao.findByManager(Integer.parseInt(managerId))).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //Indica que consume un tipo de dato que tratará de convertir a lo que recibe el parámetro.
    public Response add(Employee e) throws URISyntaxException {
        this.dao.create(e);
        return Response.created(new URI("/employee-service/api/employees/" + e.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Integer id, Employee e) {
        if (this.dao.findById(id) == null) {
            return Response.status(404).build();
        }

        e.setId(id);
        this.dao.update(e);

        return Response.status(200).entity(e).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id) {
        if (this.dao.findById(id) == null) {
            return Response.status(404).build();
        }

        this.dao.remove(this.dao.findById(id));
        
        Response res = Response.status(204).entity("Employee " + id + " deleted successfully !!").build();
        res.getHeaders().putSingle("rault", "raul");
        
        return res;
    }
}
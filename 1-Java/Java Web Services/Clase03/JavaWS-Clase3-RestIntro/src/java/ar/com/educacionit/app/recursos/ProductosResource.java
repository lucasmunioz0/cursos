/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.app.recursos;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rdurante
 */
@Path("productos")
public class ProductosResource {

    /*
     @GET
     public String holaMundo() {
     return "Hola Mundo";
     }*/
    
    /*
    @GET
    @Produces(value = MediaType.TEXT_HTML)
    public String saludar() {
        return "Bienvenido";
    }
    */
    
    @GET
    @Path("{parametro_id}")
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producto obtenerProducto(@PathParam("parametro_id") Long id) {
        System.out.println("*********************");
        System.out.println(id);
        System.out.println("*********************");
        Producto p4 = new Producto(4, "A", 100.8, true);
        return p4;
    }
    
    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> obtenerProductos() {
        Producto p1 = new Producto(1, "A", 100.8, true);
        Producto p2 = new Producto(2, "B", 88.8, true);
        Producto p3 = new Producto(3, "C", 67.8, true);
        List<Producto> productos = new ArrayList<>();
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        return productos;
    }
    
    @POST
    public String chauMundo() {
        return "Chau Mundo";
    }

}

package com.educacionit.java.web;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider //Este filtro funciona como interceptor
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request,
            ContainerResponseContext response) throws IOException {
        response.getHeaders().add("Access-Control-Allow-Origin", "*"); //Acepta todos los dominions de origen
        response.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept"); //Indica las cabeceras que permite
        response.getHeaders().add("Access-Control-Allow-Methods", //Indica los métodos que acepta
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}
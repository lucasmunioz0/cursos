package com.udemy.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.*;

public class MostrarPersona extends ActionSupport{    
    Logger log = LogManager.getLogger(MostrarPersona.class);
    
    private String nombre;

    @Override
    public String execute() throws Exception {
        log.info("El nombre es: " + nombre);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
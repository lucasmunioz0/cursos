package com.udemy.actions;

import org.apache.logging.log4j.*;

public class SaludarAction {
    Logger log = LogManager.getLogger(SaludarAction.class);
    
    private String saludosAtr;
    
    public String execute(){
        log.info("Ejecutando método execute asd.");
        saludosAtr = "Hola desde struts 2 con convenciones";
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
}

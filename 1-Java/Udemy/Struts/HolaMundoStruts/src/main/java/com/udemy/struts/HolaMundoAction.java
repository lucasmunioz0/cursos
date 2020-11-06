package com.udemy.struts;

import org.apache.logging.log4j.*;

public class HolaMundoAction {
    Logger log = LogManager.getLogger(HolaMundoAction.class);
    
    private String saludosAtr;
    
    public String execute(){
        log.info("Ejecutando método execute.");
        saludosAtr = "Adios Mundo";
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
}

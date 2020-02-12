package com.eduit.javaspring.clase2.beans.impl;

import com.eduit.javaspring.clase2.beans.ContaduriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("facturacion")
public class FacturacionService {

    @Autowired
    private ContaduriaService service;

    public FacturacionService(ContaduriaService service){
        this.service = service;
    }
    public void ejecutar(){
        service.cierreDelDia();
    }
}

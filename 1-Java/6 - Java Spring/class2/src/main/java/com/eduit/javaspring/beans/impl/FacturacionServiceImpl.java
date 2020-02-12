package com.eduit.javaspring.beans.impl;

import com.eduit.javaspring.beans.ContaduriaService;
import com.eduit.javaspring.beans.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "facturacion") //Otra forma (value="facturacion") 
public class FacturacionServiceImpl implements FacturacionService{

    private final ContaduriaService service;
    
    @Autowired
    public FacturacionServiceImpl(ContaduriaService service) {
        this.service = service;
    }
    
    @Override
    public void ejecutar(){
        service.cierreDelDia();
        System.out.println("Ejecutando Facturación service..");
    }

    @Override
    public ContaduriaService getService() {
        return service;
    }
}

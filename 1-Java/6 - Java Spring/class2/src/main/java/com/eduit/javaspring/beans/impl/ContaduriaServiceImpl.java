package com.eduit.javaspring.beans.impl;

import com.eduit.javaspring.beans.ContaduriaService;

public class ContaduriaServiceImpl implements ContaduriaService{
    
    @Override
    public void cierreDelDia(){
        System.out.println("Ejecutando cierre del día.");
    }
}

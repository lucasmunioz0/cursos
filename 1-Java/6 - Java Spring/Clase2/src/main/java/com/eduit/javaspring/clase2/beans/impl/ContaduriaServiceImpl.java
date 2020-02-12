package com.eduit.javaspring.clase2.beans.impl;

import com.eduit.javaspring.clase2.beans.ContaduriaService;
import org.springframework.stereotype.Service;

public class ContaduriaServiceImpl implements ContaduriaService {
    public void cierreDelDia() {
        System.out.println("Ejecutando cierre del día");
    }
}

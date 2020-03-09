package com.udemy.javaee.clase295.beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEJBRemote{

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando método sumar en el servidor.");
        return a + b;
    }    
}

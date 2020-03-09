package com.udemy.javaee.sga.beans;

import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(endpointInterface = "com.udemy.javaee.sga.beans.ServicioSumarWS")
@Stateless
public class ServicioSumarImpl implements ServicioSumarWS{

    @Override
    public int sumar(int a, int b) {
        return a + b;
    }
}
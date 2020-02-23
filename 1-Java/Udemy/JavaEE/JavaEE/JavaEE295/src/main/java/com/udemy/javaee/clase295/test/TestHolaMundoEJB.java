package com.udemy.javaee.clase295.test;

import com.udemy.javaee.clase295.beans.HolaMundoEJBRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class TestHolaMundoEJB {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try{
            Context jndi = new InitialContext();
            HolaMundoEJBRemote remote = (HolaMundoEJBRemote) jndi.lookup("java:global/HolaMundoEJB/HolaMundoEjbImpl!com.udemy.javaee.clase295.beans.HolaMundoEJBRemote");
            int resultado = remote.sumar(5, 3);
            System.out.println("Resultado de la suma: " + resultado);
        }catch(NamingException e){
            e.printStackTrace(System.err);
        }
    }
}

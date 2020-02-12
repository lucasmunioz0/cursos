/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduit.minihibernate.models;

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> personaClass = Class.forName("com.eduit.minihibernate.models.Persona");
        Object persona = personaClass.newInstance();
        
        System.out.println(persona);
    }
}

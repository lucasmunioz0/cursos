/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduit.clase2.common;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Lucas
 */
public class SessionFactorySingleton {
    private static SessionFactorySingleton instance;
    private final SessionFactory sf;
    
    private SessionFactorySingleton(){
        System.out.println("Creando Sevice...");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.buildMetadata();
        sf = metadata.buildSessionFactory();
    }
    
    public static SessionFactory getSessionFactory(){
        if(instance == null){
            instance = new SessionFactorySingleton();
        }
        
        return instance.sf;
    }
}

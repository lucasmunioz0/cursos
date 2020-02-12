package com.eduit.javaspring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernatePelado {
    public static void main(String[] args) {
        StandardServiceRegistry service = new StandardServiceRegistryBuilder ().configure().build();
        MetadataSources metadataSource = new MetadataSources(service);
        Metadata metadata = metadataSource.buildMetadata();
        
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        Persona p = new Persona();
        
        p.setNombre("Lucas");
        session.save(p);
        
        session.getTransaction().commit();
        
        sessionFactory.close();
    }
}

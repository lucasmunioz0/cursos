package com.eduit.javaspring.clase2.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernatePelado {

    public static void main(String[] args) {
        final SessionFactory sessionFactory = fileXML();
        final Session session = sessionFactory.openSession();

        session.beginTransaction();

        Persona p = new Persona();
        p.setNombre("Cosme Fulanito");
        session.save(p);

        session.getTransaction().commit();
    }

    private static SessionFactory fileProperties(){
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Persona.class);
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static SessionFactory fileXML(){
        final StandardServiceRegistry build = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(build);
        Metadata metadata = sources.buildMetadata();

        return  metadata.buildSessionFactory();
    }
}
package com.eduit.javahibernate.clase2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private static SessionFactorySingleton instance;
    private final SessionFactory sf;

    private SessionFactorySingleton(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        final MetadataSources metadataSources = new MetadataSources(registry);
        final Metadata metadata = metadataSources.buildMetadata();
        sf = metadata.buildSessionFactory();
    }

    public static synchronized SessionFactory getInstance(){
        if(instance == null)
            instance = new SessionFactorySingleton();
        return instance.sf;
    }
}

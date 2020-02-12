package com.eduit.clase02;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        
        MetadataSources metadataSource = new MetadataSources (serviceRegistry);
        Metadata metadata = metadataSource.buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        
        
    }
}

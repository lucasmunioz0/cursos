package com.eduit.clase1;

import com.eduit.clase1.model.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        final MetadataSources metadataSources = new MetadataSources(registry);
        final Metadata metadata = metadataSources.buildMetadata();
        final SessionFactory sessionFactory = metadata.buildSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try{
            final Persona p = new Persona();
            p.setNombre("Cosme Fulanito");

            session.save(p);
            session.getTransaction().commit();
        }catch(Exception e){
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }

        //session.close();
        //sessionFactory.close();
    }
}

package com.eduit.javahibernate.class1;

import com.eduit.javahibernate.class1.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Programa {
    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        MetadataSources sources = new MetadataSources(serviceRegistry);
        Metadata metadata = sources.buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Person person = new Person();
        person.setNombre("Cosme Fulanito");
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

package com.eduit.javahibernate.clase5;

import com.eduit.javahibernate.clase5.models.Legajo;
import com.eduit.javahibernate.clase5.models.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry build = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        MetadataSources sources = new MetadataSources(build);
        Metadata metadata = sources.buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        final Session session = sessionFactory.openSession();
        final Persona persona = new Persona();
        persona.setNombre("Lucas");

        Legajo legajo = new Legajo();
        legajo.setContenido("Contenido Legajo");
        legajo.setNumero(62822);

        persona.setLegajo(legajo);
        session.save(persona);
        //session.save(legajo);


        session.close();
        sessionFactory.close();
    }
}

package com.eduit.clase1;

import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import org.hibernate.service.*;
import org.hibernate.*;
import com.eduit.clase1.model.Persona;
import java.time.LocalDate;
import java.time.Month;

public class Clase1 {
    public static void main(String[] args) {
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        Persona persona = new Persona();
        persona.setNombre("Lucas Muñoz");
        persona.setFechaNacimiento(LocalDate.of(1993, Month.DECEMBER, 15));
        
        session.getTransaction().begin();
        session.save(persona);
        session.getTransaction().commit();
//        session.close();
//        sessionFactory.close();
    }
}

package com.eduit.clase2;

import com.eduit.clase2.common.SessionFactorySingleton;
import com.eduit.clase2.models.Curso;
import com.eduit.clase2.models.Persona;
import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;

public class Clase2 {

    public static void main(String[] args) {
        SessionFactory sf = SessionFactorySingleton.getSessionFactory();
        Session session1 = sf.openSession();
        Session session2 = sf.openSession();
        Persona p = new Persona();
        try {
            session1.beginTransaction();
            
            p.setNombre("Lucas");

            session1.save(p);

            session1.getTransaction().commit();
            session1.clear();
            Persona persona = session1.get(Persona.class, 1L);
            System.out.println(persona);
        } catch (Exception e) {
            e.printStackTrace();
            session1.getTransaction().rollback();
        }
        session1.close();
        
        try {
            session2.beginTransaction();

            Persona p2 = new Persona();
            p2.setNombre("Profesor Jirafales");
            
            Curso c = new Curso();
            c.setNombre("Java Hibernate");
            c.setPrecio(5000);
            
            session2.save(p2);
            session2.save(c);
            
            session2.getTransaction().commit();
            
            Session session3 = sf.openSession();
            Query query = session3.createQuery("FROM Persona WHERE id=:id");
            query.setParameter("id", 1L);
            List<Persona> personas = query.list();
            
            for (Persona persona : personas) {
                System.out.println(persona);
            }
            
//            for (Object persona : personas) {
//                System.out.println(persona);
//            }
            
            
            session3.close();
        } catch (Exception e) {
            e.printStackTrace();
            session2.getTransaction().rollback();
        }

        
        session2.close();
        sf.close();
    }
}

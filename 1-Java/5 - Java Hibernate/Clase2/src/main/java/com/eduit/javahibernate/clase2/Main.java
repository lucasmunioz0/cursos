package com.eduit.javahibernate.clase2;

import com.eduit.javahibernate.clase2.model.Curso;
import com.eduit.javahibernate.clase2.model.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Session session1 = SessionFactorySingleton.getInstance().openSession();
        session1.beginTransaction();
        final Persona p = new Persona();
        p.setNombre("Cosme");

        session1.save(p);
        session1.close();

        Session session2 = SessionFactorySingleton.getInstance().openSession();
        Transaction tx = session2.beginTransaction();
        Persona p2 = new Persona();
        Curso curso = new Curso();
        curso.setNombre("Java Hibernate");
        curso.setPrecio(1000D);
        p2.setNombre("Profesor Jirafales");

        session2.save(p2);
        session2.save(curso);
        tx.commit();

        session2.close();

        //HQL o JPQL
        Session session3 = SessionFactorySingleton.getInstance().openSession();
        final Query query = session3.createQuery("FROM Persona p WHERE nombre = :nombre"); //para usar posiciones cambiar :nombre por ?1
        query.setParameter("nombre", "Cosme");
        List list = query.list();
        list.forEach(System.out::println);
//        //session1.evict(p); A diferencia del clear, solamente evita 1 objeto.
//
//        System.out.println("Despues del save");
//        System.out.println("1- Dirty: " + session1.isDirty());
//        //p.setNombre("Pablo Marmol"); //En caso de quitar el evict, se visualiza un update.
//        System.out.println("2- Dirty: " + session1.isDirty());
//        session1.getTransaction().commit();
//
//        //Se limpia la cache para visualizar el select en la consola
//        session1.clear();
//
//        final Persona persona = session1.get(Persona.class, 1L);
//        System.out.println(persona.getNombre());
//        session1.close();
//
//        final Session session2 = sf.openSession();
//        System.out.println("Antes del select:");
//        final Persona persona2 = session2.load(Persona.class, 1L);
//        System.out.println("Antes del nombre:");
//        System.out.println(persona2.getNombre());
//        session2.beginTransaction();
//        session2.delete(persona2);
//        p.setNombre("Modificado");
//        session2.clear();
//        session2.update(p);
//        session2.getTransaction().commit();
//        session2.close();
//
        //sf.close();
    }
}

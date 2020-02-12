package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.config.SessionManager;
import com.eduit.javahibernate.laboratorio.model.Concesionario;
import org.hibernate.Session;

import java.util.List;

public class Laboratorio2 {
    public static void main(String[] args) {
        getConcesionarios();
        insertConcesionario();
        getConcesionarios();
        updateConcesionario(3L);
        getConcesionarios();
        getConcesionario(2L);
        deleteConcesionario(3L);
        getConcesionarios();
    }

    private static void deleteConcesionario(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            session.beginTransaction();
            Concesionario concesionario = new Concesionario();
            concesionario.setId(id);
            session.delete(concesionario);
            session.getTransaction().commit();
        }
    }

    private static void getConcesionario(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Concesionario concesionario = session.get(Concesionario.class, id);
            System.out.println(concesionario.toString());
        }
    }

    private static void updateConcesionario(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            session.beginTransaction();
            Concesionario concesionario = new Concesionario("Parra", "ACTUALIZADO: Av. Donato Alvarez 1540");
            concesionario.setId(id);
            session.update(concesionario);
            session.getTransaction().commit();
        }
    }

    private static void insertConcesionario() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            session.beginTransaction();
            Concesionario concesionario1 = new Concesionario("Parra", "Castro Barros 1540");
            Concesionario concesionario2 = new Concesionario("Mondeo", "Saavedra 156");
            Concesionario concesionario3 = new Concesionario("AutoHaus", "Luchesse frente Zoco");
            session.save(concesionario1);
            session.save(concesionario2);
            session.save(concesionario3);
            session.getTransaction().commit();
        }
    }

    private static void getConcesionarios() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Concesionario> consecionarios = session.createQuery("FROM Concesionario").list();
            consecionarios.forEach(System.out::println);
        }
    }
}

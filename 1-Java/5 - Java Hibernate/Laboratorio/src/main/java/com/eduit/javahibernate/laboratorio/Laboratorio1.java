package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.config.SessionManager;
import com.eduit.javahibernate.laboratorio.model.Auto;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class Laboratorio1 {
    public static void main(String[] args) {
        getAutos();
        insertAutos();
        getAutos();
        updateAuto(3L);
        getAutos();
        getAuto(11L);
        //deleteAuto(3L);
        getAutos();
    }

    private static void deleteAuto(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            session.beginTransaction();
            Auto auto = new Auto();
            auto.setId(id);
            session.delete(auto);
            session.getTransaction().commit();
        }
    }

    private static void getAuto(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Auto auto = session.get(Auto.class, id);
            System.out.println(auto);
        }
    }

    private static void updateAuto(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            session.beginTransaction();
            Auto autoModificado = new Auto("ACTUALIZADO: Chevrolet 5P", "2020", 40000D, LocalDate.of(2005, 06, 9));
            autoModificado.setId(id);
            session.update(autoModificado);
            session.getTransaction().commit();
        }
    }

    private static void insertAutos() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Auto auto1 = new Auto("Fiat", "2000", 15000D, LocalDate.of(2002, 05, 25));
            Auto auto2 = new Auto("Fiat", "2000", 5000D, LocalDate.of(2002, 04, 01));
            Auto auto3 = new Auto("Chevrolet", "2005", 50000D, LocalDate.of(2002, 01, 18));
            Auto auto4 = new Auto("Nissan", "1993", 10000D, LocalDate.of(2001, 03, 01));
            Auto auto5 = new Auto("Citroen", "1995", 25000D, LocalDate.of(1995, 8, 10));
            Auto auto6 = new Auto("Ford", "2015", 7500D, LocalDate.of(2017, 12, 15));
            Auto auto7 = new Auto("Fiat", "2020", 75000D, LocalDate.of(2020, 11, 23));
            Auto auto8 = new Auto("Citroen", "2017", 30000D, LocalDate.of(2015, 9, 21));
            Auto auto9 = new Auto("Fiat", "1998", 20000D, LocalDate.of(2008, 07, 22));
            Auto auto10 = new Auto("Chevrolet", "2003", 8000D, LocalDate.of(2003, 06, 29));
            session.beginTransaction();
            session.save(auto1);
            session.save(auto2);
            session.save(auto3);
            session.save(auto4);
            session.save(auto5);
            session.save(auto6);
            session.save(auto7);
            session.save(auto8);
            session.save(auto9);
            session.save(auto10);
            session.getTransaction().commit();
        }
    }

    private static void getAutos() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = session.createQuery("From Auto").list();
            autos.forEach(System.out::println);
        }
    }
}

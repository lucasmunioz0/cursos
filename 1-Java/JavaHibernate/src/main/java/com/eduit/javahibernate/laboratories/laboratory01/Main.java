package com.eduit.javahibernate.laboratories.laboratory01;

import com.eduit.javahibernate.laboratories.utils.SessionManager;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        getAutos();
        //insertAuto();
        getAutos();
        updateAuto(5L);
        getAutos();
        getAuto(3L);
        //deleteAuto(3L);
        getAutos();
    }

    private static void getAutos() {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            List<Auto> autos = session.createQuery("FROM com.eduit.javahibernate.laboratories.laboratory01.Auto").list();
            autos.forEach(System.out::println);
        }
    }

    private static void insertAuto() {
        Auto auto1 = new Auto("Fiat", "2001", LocalDate.of(1993, 12, 15), 15500.50);
        Auto auto2 = new Auto("Fiat", "2000", LocalDate.of(2000, 12, 15), 20000.50);
        Auto auto3 = new Auto("Citroen", "2000", LocalDate.of(2000, 12, 15), 10000.50);
        Auto auto4 = new Auto("Citroen", "2000", LocalDate.of(2005, 12, 15), 75000.);
        Auto auto5 = new Auto("Chevrolet", "2005", LocalDate.of(1993, 12, 15), 35000D);
        
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.save(auto1);
            session.save(auto2);
            session.save(auto3);
            session.save(auto4);
            session.save(auto5);
            tx.commit();
        }catch(RuntimeException e){}
    }

    private static void updateAuto(Long id) {
        Auto auto = new Auto("Chevrolet", "2005 Modificado", LocalDate.of(1993, 12, 15), 35000D);
        auto.setId(id);
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.update(auto);
            tx.commit();
        }catch(RuntimeException e){}
    }

    private static void getAuto(long id) {
        Auto auto = new Auto();
        auto.setId(id);
        try(Session session = SessionManager.getSessionFactory().openSession()){
            auto = session.get(Auto.class, id);
        }catch(RuntimeException e){}
        
        System.out.println(auto);
    }

    private static void deleteAuto(long id) {
        Auto auto = new Auto();
        auto.setId(id);
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            session.delete(auto);
            tx.commit();
        }catch(RuntimeException e){}
    }
}

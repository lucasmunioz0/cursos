package com.eduit.javahibernate.laboratories.laboratory02;

import com.eduit.javahibernate.laboratories.utils.SessionManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        getCarDealers();
        insertCarDealers();
        getCarDealers();
        updateCarDealers(1L);
        getCarDealers();
        getCarDealer(3L);
        deleteCarDealers(3L);
        getCarDealers();
    }

    private static void getCarDealers() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Concesionaria> carDealers = session.createQuery("FROM Concesionaria").list();
            carDealers.forEach(System.out::println);
        }
    }

    private static void insertCarDealers() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Concesionaria parra = new Concesionaria("Parra", "Luchesse 255");
            Concesionaria mondeo = new Concesionaria("Mondeo", "San Juan 1549");
            Concesionaria autocity = new Concesionaria("Autocity", "Saavedra 156");
            Transaction tx = session.beginTransaction();
            session.save(parra);
            session.save(mondeo);
            session.save(autocity);
            tx.commit();
        }catch(RuntimeException e){}
    }

    private static void updateCarDealers(Long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Concesionaria carDealer = new Concesionaria("Parra", "Luchesse 255 Villa Allende");
            carDealer.setId(id);
            Transaction tx = session.beginTransaction();
            session.update(carDealer);
            tx.commit();
        }catch(RuntimeException e){}
    }

    private static void getCarDealer(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Concesionaria carDealer = session.get(Concesionaria.class, id);
            System.out.println(carDealer);            
        }
    }

    private static void deleteCarDealers(long id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Concesionaria carDealer = new Concesionaria("", "");
            carDealer.setId(id);
            Transaction tx = session.beginTransaction();
            session.delete(carDealer);
            tx.commit();
        }catch(RuntimeException e){e.printStackTrace();}
        
    }
}

package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.config.SessionManager;
import com.eduit.javahibernate.laboratorio.model.Auto;
import org.hibernate.Session;

import java.util.List;

public class Laboratorio6 {
    public static void main(String[] args) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = session.getNamedQuery("laboratorio6").list();
            autos.forEach(System.out::println);
        }
    }
}

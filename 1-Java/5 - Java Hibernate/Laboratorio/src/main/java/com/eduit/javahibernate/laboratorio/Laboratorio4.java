package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.config.SessionManager;
import com.eduit.javahibernate.laboratorio.model.Auto;
import org.hibernate.Session;

import java.util.List;

public class Laboratorio4 {
    public static void main(String[] args) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = TestQueriesParametrizadas.obtenerAutosSegunCriterio(session, "0", "Chev");
            autos.forEach(System.out::println);
        }
    }
}

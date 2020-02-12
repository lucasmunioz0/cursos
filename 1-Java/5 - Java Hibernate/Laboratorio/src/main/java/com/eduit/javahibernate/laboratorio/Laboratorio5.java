package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.config.SessionManager;
import com.eduit.javahibernate.laboratorio.model.Auto;
import org.hibernate.Session;

import java.util.List;

public class Laboratorio5 {
    public static void main(String[] args) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            int cantidad = 10;
            int posicion = 3;
            List<Auto> autos = TestPaginacion.obtenerAutosConPaginacion(session, posicion, cantidad);
            autos.forEach(System.out::println);
        }
    }
}

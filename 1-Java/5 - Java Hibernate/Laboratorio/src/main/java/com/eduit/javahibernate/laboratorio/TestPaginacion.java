package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.model.Auto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TestPaginacion {
    public static List obtenerAutosConPaginacion(Session session, int registroInicial, int cantidad){
        final Query query = session.createQuery("FROM Auto");
        query.setMaxResults(cantidad);
        query.setFirstResult(registroInicial);
        final List<Auto> autos = query.list();
        return autos;
    }
}
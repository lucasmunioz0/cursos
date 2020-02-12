package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.model.Auto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TestQueriesParametrizadas {
    public static List<Auto> obtenerAutosSegunCriterio(Session session, String unModelo, String unaMarca){
        final Query laboratorio4 = session.getNamedQuery("laboratorio4");
        laboratorio4.setParameter("modelo", "%" + unModelo + "%");
        laboratorio4.setParameter("marca", "%" + unaMarca + "%");
        final List<Auto> autos = laboratorio4.list();
        return autos;
    }
/*
    El método deberá retornar los autos correspondientes al modelo y a la marca pasados como parámetros. Dentro del método,
    construir una consulta parametrizada con HQL que reciba como parámetro el modelo y la marca del auto y obtenga todos los autos correspondientes a esos parámetros.

    El método deberá aceptar búsquedas no absolutas, es decir deberá permitir obtener los autos tal que:

    su modelo termine con “04” (representando al 2004)
    su marca comience con “Chev” (representando a Chevrolet)
    si recibe en marca y modelo los valores “” (strings vacíos) o null deberá traer todos los autos
    Realizar la prueba del método anterior dentro del método main de esta clase.
    */
}

package com.eduit.javahibernate.laboratorio;

import com.eduit.javahibernate.laboratorio.config.SessionManager;
import com.eduit.javahibernate.laboratorio.model.Auto;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Laboratorio3 {
    public static void main(String[] args) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            System.out.println("1. Todos los autos ordenados en forma descendente por fecha de venta.");
            punto1(session);
            System.out.println("2. Los autos con fecha de venta entre 2002-01-01 y 2003-01-01.");
            punto2(session);
            System.out.println("3. Los autos modelo 2000.");
            punto3(session);
            System.out.println("4. Los autos cuya marca comienza con la letra C.");
            punto4(session);
            System.out.println("5. Los autos con precio mayor a 15000.");
            punto5(session);
            System.out.println("6. La cantidad total de autos.");
            punto6(session);
            System.out.println("7. La cantidad total de marcas diferentes.");
            punto7(session);
            System.out.println("8. El precio más alto.");
            punto8(session);
            System.out.println("9. El promedio de precios.");
            punto9(session);
            System.out.println("10. El monto total de venta agrupado por marca.");
            punto10(session);
            System.out.println("11. Producto cartesiano entre autos y concesionarios.");
            punto11(session);
        }
    }

    /**
     * 1. Todos los autos ordenados en forma descendente por fecha de venta.
     */
    private static void punto1(Session session) {
        List<Auto> autos = session.createQuery("FROM Auto a order by a.fechaVenta").list();
        mostrarAutos(autos);
    }

    /**
     * 2. Los autos con fecha de venta entre 2002-01-01 y 2003-01-01.
     */
    private static void punto2(Session session) {
        List<Auto> autos = session.createQuery("FROM Auto a where a.fechaVenta between '2002-01-01' and '2003-01-01'").list();
        mostrarAutos(autos);
    }

    /**
     * 3. Los autos modelo 2000.
     */
    private static void punto3(Session session) {
        List<Auto> autos = session.createQuery("FROM Auto a where a.modelo = '2000'").list();
        mostrarAutos(autos);
    }

    /**
     * 4. Los autos cuya marca comienza con la letra C.
     */
    private static void punto4(Session session) {
        List<Auto> autos = session.createQuery("FROM Auto a where a.marca like 'C%'").list();
        mostrarAutos(autos);
    }

    /**
     * 5. Los autos con precio mayor a 15000.
     */
    private static void punto5(Session session) {
        List<Auto> autos = session.createQuery("FROM Auto a where a.precio > 15000").list();
        mostrarAutos(autos);
    }

    /**
     * 6. La cantidad total de autos.
     */
    private static void punto6(Session session) {
        Long query = (Long) session.createQuery("SELECT count(1) FROM Auto a").uniqueResult();
        System.out.println("Cantidad total de autos: " + query);
    }

    /**
     * 7. La cantidad total de marcas diferentes.
     */
    private static void punto7(Session session) {
        Long query = (Long) session.createQuery("SELECT count(distinct a.marca) FROM Auto a").uniqueResult();
        System.out.println("Cantidad total de marcas diferentes: " + query);
    }

    /**
     * 8. El precio más alto.
     */
    private static void punto8(Session session) {
        Double query = (Double) session.createQuery("SELECT max(a.precio) FROM Auto a").uniqueResult();
        System.out.println("Precio más alto: $" + new DecimalFormat("###,###.##").format(query));
    }

    /**
     * 9. El promedio de precios.
     */
    private static void punto9(Session session) {
        Double query = (Double) session.createQuery("SELECT avg(a.precio) FROM Auto a").uniqueResult();
        System.out.println("Promedio de precios: $" + new DecimalFormat("###,###.##").format(query));
    }

    /**
     * 10. El monto total de venta agrupado por marca.
     */
    private static void punto10(Session session) {
        Query query = session.createQuery("SELECT sum(a.precio), a.marca FROM Auto a group by a.marca");
        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object[] row = (Object[]) it.next();
            System.out.println(String.format("Marca: %s - Monto total: $%s", row[1], new DecimalFormat("###,###.##").format(row[0])));
        }
    }

    /**
     * 11. Producto cartesiano entre autos y concesionarios.
     */
    private static void punto11(Session session) {
//        Query query = session.createQuery("FROM Auto a, Concesionario c");
//        Iterator it = query.iterate();
//        while (it.hasNext()) {
//            Object[] row = (Object[]) it.next();
//            mostrarFila(row);
//        }
        String qry = "FROM Auto, Concesionario";

        // Realiza la consulta
        List datos = session.createQuery(qry).list();

        // Recorre los datos obtenidos
        Iterator it = datos.iterator();
        while( it.hasNext() )
        {
            Object[] dato = (Object[]) it.next();
            System.out.println("Auto: " + dato[0]);
            System.out.println("Concesionario: " + dato[1]);
            System.out.println("--------");

        }
    }

    private static void mostrarAutos(Collection<Auto> collection) {
        collection.forEach(System.out::println);
    }

    private static void mostrarFila(Object[] row) {
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i] + " | ");
        }
        System.out.println();
    }
}
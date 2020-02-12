package com.eduit.javahibernate.laboratories.laboratory03;

import com.eduit.javahibernate.laboratories.laboratory01.Auto;
import com.eduit.javahibernate.laboratories.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Punto 1: Todos los autos ordenados en forma descente por fecha de venta");
        item1();
        System.out.println("Punto 2: Los autos con fecha de venta entre 2002-01-01 y 2003-01-01");
        item2();
        System.out.println("Punto 3: Los autos modelo 2000");
        item3();
        System.out.println("Punto 4: Los autos cuya marca comienza con la letra C.");
        item4();
        System.out.println("Punto 5: Los autos con precio mayor a 15000.");
        item5();
        System.out.println("Punto 6: La cantidad total de autos.");
        item6();
        System.out.println("Punto 7: La cantidad total de marcas diferentes.");
        item7();
        System.out.println("Punto 8: El precio más alto.");
        item8();
        System.out.println("Punto 9: El promedio de precios.");
        item9();
        System.out.println("Punto 10: El monto total de venta agrupado por marca.");
        item10();
        System.out.println("Punto 11: Producto cartesiano entre autos y concesionarios.");
        //item11();
    }

    /**
     * Punto 11: Producto cartesiano entre autos y concesionarios.
     */
    private static void item11() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Query query = session.createQuery("SELECT a, c from Auto a, Concesionaria c");
            //query.setFetchSize(100);
            Iterator it = query.iterate();
            while(it.hasNext()){
                Object[] row = (Object[]) it.next();
                printRow(row);
            }
        }
    }

    private static void printRow(Object[] row) {
        for (int i = 0; i < row.length; i++) {
            System.out.print(row[i] + " | ");
        }
        System.out.println();
    }

    /**
     * Punto 10: El monto total de venta agrupado por marca.
     */
    private static void item10() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Query query = session.createQuery("SELECT sum(a.price), a.tradeMark from Auto a group by a.tradeMark");
            Iterator it = query.iterate();
            while(it.hasNext()){
                Object[] row = (Object[]) it.next();
                System.out.println(String.format("%s Monto total: $%s", row[1], new DecimalFormat("###,###.##").format(row[0])));
            }
        }
    }

    /**
     * Punto 9: El promedio de precios.
     */
    private static void item9() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Double autos = (Double) session.createQuery("SELECT AVG(a.price) from Auto a").uniqueResult();
            System.out.println(String.format("Promedio de precios: $%s", new DecimalFormat("###,###.##").format(autos)));
        }
    }

    /**
     * Punto 8: El precio más alto.
     */
    private static void item8() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Double autos = (Double) session.createQuery("SELECT MAX(a.price) from Auto a").uniqueResult();
            System.out.println("Precio más alto: $" + autos);
        }
    }

    /**
     * Punto 7: La cantidad total de marcas diferentes.
     */
    private static void item7() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Long autos = (Long) session.createQuery("SELECT count(DISTINCT a.tradeMark) from Auto a").uniqueResult();
            System.out.println("Cantidad de marcas diferentes: " + autos);
        }
    }

    /**
     * La cantidad total de autos.
     */
    private static void item6() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Long autos = (Long) session.createQuery("SELECT count(1) from Auto a").uniqueResult();
            System.out.println("Cantidad de autos: " + autos);
        }
    }

    /**
     * 5.Los autos con precio mayor a 15000.
     */
    private static void item5() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = session.createQuery("FROM Auto a WHERE a.price > 15000").list();
            printAutos(autos);
        }
    }

    /**
     * Punto 4: Los autos cuya marca comienza con la letra C.
     */
    private static void item4() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = session.createQuery("FROM Auto a WHERE a.tradeMark LIKE 'C%'").list();
            printAutos(autos);
        }
    }

    /**
     * Los autos modelo 2000
     */
    private static void item3() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = session.createQuery("FROM Auto a WHERE a.model = '2000'").list();
            printAutos(autos);
        }
    }

    /**
     * Los autos con fecha de venta entre 2002-01-01 y 2003-01-01
     */
    private static void item2() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = session.createQuery("FROM Auto a WHERE a.saleDate between '2002-01-01' and '2003-01-01'").list();
            printAutos(autos);
        }
    }

    /**
     * Todos los autos ordenados en forma descente por fecha de venta
     */
    private static void item1() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            List<Auto> autos = session.createQuery("FROM com.eduit.javahibernate.laboratories.laboratory01.Auto ORDER BY saleDate desc").list();
            printAutos(autos);
        }
    }

    private static void printAutos(Collection collection){
        collection.forEach(System.out::println);
    }
}

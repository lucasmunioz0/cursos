package com.eduit.javahibernate.classroom1;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarTest {
    public static void main(String[] args) {
        //insertCar();
        getCars();
        //updateCar();
        //getCars();
        deleteCar();
        getCars();
    }

    private static void insertCar() {
        Car car1 = new Car("Fiat", "2000");
        try (Session session = SessionManager.getSession()) {
            Transaction tx = session.beginTransaction();
            session.save(car1);
            tx.commit();
        }
    }

    private static void getCars() {
        try (Session session = SessionManager.getSession()) {
            List<Car> cars;
            cars = session.createQuery("from com.eduit.havahibernate.classroom1.Car").list();
            cars.forEach((car) -> {
                System.out.println(car);
            });
        }
    }

    private static void updateCar() {
        Car car1 = new Car("Fiat Editado", "2500");
        car1.setId(1L);
        try (Session session = SessionManager.getSession()) {
            Transaction tx = session.beginTransaction();
            session.update(car1);
            tx.commit();
        }
    }

    private static void deleteCar() {
        Car car1 = new Car();
        car1.setId(1L);
        try (Session session = SessionManager.getSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(car1);
            tx.commit();
        }
    }
}

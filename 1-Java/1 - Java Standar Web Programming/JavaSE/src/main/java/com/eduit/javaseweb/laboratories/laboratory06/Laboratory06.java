package com.eduit.javaseweb.laboratories.laboratory06;

import java.sql.SQLException;

public class Laboratory06 {

    public static void main(String[] args) throws SQLException {
        Person newPerson = new Person(0, "Lucas", "Muñoz", 25);
        System.out.println("Insert Person");
        PersonDao.insert(newPerson);       
        System.out.println(newPerson);
        
        System.out.println("Updating...");
        Person update = new Person(3, "Lucas Martin", "Muñoz", 26);
        PersonDao.update(update);
        System.out.println(update);
        
        System.out.println("Getting...");
        Person find = new Person();
        find.setId(2);
        find = PersonDao.get(find);
        System.out.println(find);
        
        System.out.println("Deleting...");
        Person toDelete = new Person();
        toDelete.setId(2);
        PersonDao.delete(toDelete);
    }
}
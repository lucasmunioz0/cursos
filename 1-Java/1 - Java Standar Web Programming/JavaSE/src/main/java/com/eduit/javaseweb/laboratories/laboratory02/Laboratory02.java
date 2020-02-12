package com.eduit.javaseweb.laboratories.laboratory02;

public class Laboratory02 {
    public static void main(String[] args) {
        Residence residence = new Residence("San Juan", "Villa Allende", 1549);
        Person person = new Person("Lucas", "Muñoz", residence , 25);
        System.out.println(person);
    }
}
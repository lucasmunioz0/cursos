package com.eduit.javaseweb.laboratories.laboratory08;

public class Laboratory08 {
    public static void main(String[] args) {
        Person person1 = new Person("37627180", "Lucas", "Muñoz");
        Person person2 = new Person("37627180", "Lucas", "Muñoz");
        Person person3 = new Person("37627180", "Lucas", "Muñoz");
        Bank bank = new Bank();
        bank.addPerson(person1);
        bank.addPerson(person2);
        bank.addPerson(person3);
        
        System.out.println(bank);
    }   
}
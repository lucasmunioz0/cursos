package com.eduit.javaseweb.laboratories.laboratory02;

public class Person {
    private String name;
    private String lastName;
    private Residence residence;
    private int age;

    public Person(String name, String lastName, Residence residence, int age) {
        this.name = name;
        this.lastName = lastName;
        this.residence = residence;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (%d) - Residence: %s", lastName, name, age, residence.toString());
    }
}

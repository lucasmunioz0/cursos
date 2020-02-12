package com.eduit.javaseweb.laboratories.laboratory03.models;

public class Person {
    private String name;
    private String lastName;
    private String documentNumber;

    public Person(String name, String lastName, String documentNumber) {
        this.name = name;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (%s)", name, lastName, documentNumber);
    }    
}

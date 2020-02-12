package com.eduit.javaseweb.laboratories.laboratory08;

import java.util.Objects;

public class Person {
    private String documentNumber;
    private String name;
    private String lastName;

    public Person(String documentNumber, String name, String lastName) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" + "documentNumber=" + documentNumber + ", name=" + name + ", lastName=" + lastName + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return ((Person) obj).documentNumber.equalsIgnoreCase(this.documentNumber);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.documentNumber);
        return hash;
    }

    
}

package com.eduit.javaseweb.laboratories.laboratory02;

public class Residence {
    private String street;
    private String locality;
    private int number;

    public Residence(String street, String locality, int number) {
        this.street = street;
        this.locality = locality;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%s - %s %d", locality, street, number);
    }
}
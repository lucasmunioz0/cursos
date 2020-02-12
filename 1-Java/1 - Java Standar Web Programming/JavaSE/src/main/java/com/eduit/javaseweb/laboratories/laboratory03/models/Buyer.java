package com.eduit.javaseweb.laboratories.laboratory03.models;

public class Buyer extends Person{
    private double budget;

    public Buyer(double budget, String name, String lastName, String documentNumber) {
        super(name, lastName, documentNumber);
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", super.toString(), budget);
    }    
}

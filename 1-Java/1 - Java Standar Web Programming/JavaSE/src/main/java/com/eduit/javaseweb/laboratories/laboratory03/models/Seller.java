package com.eduit.javaseweb.laboratories.laboratory03.models;

public class Seller extends Person{
    private int countVehiclesSold;

    public Seller(int countVehiclesSold, String name, String lastName, String documentNumber) {
        super(name, lastName, documentNumber);
        this.countVehiclesSold = countVehiclesSold;
    }

    @Override
    public String toString() {
        return String.format("%s Vehicles sold: %d", super.toString(), countVehiclesSold);
    }
}

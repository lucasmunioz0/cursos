package com.eduit.javaseweb.integrator.models;

public class Product {
    private int id;
    private double price;
    private String description;

    public Product(int id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%s $%.2f", description, price);
    }
}

package com.eduit.javaseweb.laboratories.laboratory03.models;

public class Car extends Vehicle{
    private String trademark;
    private String model;
    private String color;

    public Car(String trademark, String model, String color, int height, int width, int length) {
        super(height, width, length);
        this.trademark = trademark;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s, %s %s %s", trademark, model, color, super.toString());
    }
}

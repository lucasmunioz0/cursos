package com.eduit.javaseweb.laboratories.laboratory03.models;

public class Vehicle {
    private int height;
    private int width;
    private int length;

    public Vehicle(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("Height: %d - Width: %d - Length: %d", height, width, length);
    }    
}
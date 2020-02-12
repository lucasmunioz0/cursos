package com.eduit.javaseweb.laboratories.laboratory03;

import com.eduit.javaseweb.laboratories.laboratory03.models.*;

public class Laboratory03 {
    public static void main(String[] args) {
        Car car = new Car("Citroen", "C3", "Grey", 180, 150, 180);
        Buyer buyer = new Buyer(9000, "Lucas", "Muñoz", "37627180");
        Seller seller = new Seller(8, "Jose", "Manuel", "40152681");
        
        System.out.println(car);
        System.out.println(buyer);
        System.out.println(seller);
    }
}

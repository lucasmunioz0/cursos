/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.eduit.course.laboratories.laboratory2;

/**
 *
 * @author PC
 */
public class Main2 {
    public static void main(String[] args) {
        Product2 product = new Product2("Coca", 500);
        Runnable consumer = new Consumer2(product);
        Runnable producer = new Producer2(product);
        
        new Thread(consumer).start();
        new Thread(producer).start();
    }
}

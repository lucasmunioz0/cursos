/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strategy;


public class Main {
    public static void main(String[] args) {
        Object datos = new Object();
        FourierCalculator fourierCalculator = new FT();
        System.out.println(fourierCalculator.calcular(datos));
    }
}

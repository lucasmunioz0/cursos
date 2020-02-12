package com.eduit.javaseweb.laboratories.laboratory01;

public class Laboratory01 {
    public static void main(String[] args) {
        int[] vecNumbers = {11, -22, 33, -44, 55, -66, 77, -88, 99};
        
        int totalPositives = 0;
        int totalNegatives = 0;
        for (int i = 0; i < vecNumbers.length; i++) {
            int number = vecNumbers[i];
            if( number > 0){
                totalPositives += number;
            }else{
                totalNegatives += number;
            }            
        }
        
        System.out.printf("\nTotal Positives: %d \nTotal Negatives: %d", totalPositives, totalNegatives);
    }
}

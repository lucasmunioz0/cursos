package com.eduit.javaseweb.laboratories.laboratory05;

public class Calculator {
    public int add(int a, int b){
        if(a < 0 || a > 1000 || b < 0 || b > 1000)
            throw new ArithmeticException("The arguments cannot be less than 0 or greater than 1000.");
        
        return a + b;
    }
    
    public int subtract(int a, int b){
        if(a < 0 || a > 1000 || a < b)
            throw new ArithmeticException("The arguments or the subtract cannot be less than 0.");
        return a - b;
    }
}

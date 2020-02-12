package ar.com.eduit.course.class01;

import java.util.logging.Level;
import java.util.logging.Logger;

/*

*/
public class ThreadR implements Runnable{
    private String nombre;

    public ThreadR(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("%s %d", nombre, i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }    
}
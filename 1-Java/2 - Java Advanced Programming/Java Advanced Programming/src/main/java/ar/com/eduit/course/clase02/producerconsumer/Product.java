package ar.com.eduit.course.clase02.producerconsumer;

public class Product {

    private boolean produciendo = true;

    public synchronized void consumir(int cantidad) {
        if (produciendo == true) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }

        for (int i = cantidad; i > 0; i--) {
            System.out.println("Consumiendo: " + i);
        }
        notifyAll();
    }

    public synchronized void producir(int cantidad) {
        if (produciendo == true) {
            for (int i = 0; i < cantidad; i++) {
                System.out.println("Produciendo: " + i);
            }
            notifyAll();
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
    }
}
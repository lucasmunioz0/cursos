package ar.com.eduit.course.laboratories.laboratory2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Product2 {

    private String name;
    private int size;
    private boolean isProducing;
    private int actualAmount;

    public Product2(String name, int size) {
        this.name = name;
        this.size = size;
        this.actualAmount = size;
    }

    public synchronized void consume(int quantity) {
        if (isProducing) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        } else {
            if (actualAmount - quantity <= 0) {
                actualAmount = 0;
                isProducing = true;
                notifyAll();
            } else {
                actualAmount -= quantity;
            }
        }
    }

    public synchronized void produce(int quantity) {
        if (isProducing) {
            if (quantity + actualAmount > size) {
                actualAmount = size;
                isProducing = false;
                notifyAll();
            } else {
                actualAmount += quantity;
            }
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s Size: %d Actual Level: %d", name, size, actualAmount);
    }
}
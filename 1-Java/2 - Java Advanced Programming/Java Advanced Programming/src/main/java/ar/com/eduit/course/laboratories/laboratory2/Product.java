package ar.com.eduit.course.laboratories.laboratory2;

public class Product {

    private String name;
    private int actualAmount;
    private final int totalAmount;
    private boolean isProducing;

    public Product(String name, int totalAmount) {
        this.name = name;
        this.totalAmount = totalAmount;
    }

    public synchronized void consume(int amount) {
        if (isProducing) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        } else {
            for (int i = 1; i <= amount; i++) {
                if (actualAmount <= 0) {
                    actualAmount = 0;
                    break;
                }
                System.out.println("Consuming...");
                actualAmount -= (int) (Math.random() * 10) + 1;
                System.out.println(this);
            }
            System.out.println("Consumer finalized");
            isProducing = true;
            notifyAll();
        }
    }

    public synchronized void produce(int amount) {
        if (isProducing) {
            for (int i = 1; i <= amount; i++) {
                if (actualAmount >= totalAmount) {
                    actualAmount = totalAmount;
                    break;
                }
                System.out.println("Producing...");
                actualAmount += (int) (Math.random() * 10) + 1;
                System.out.println(this);
            }
            System.out.println("Producer finalized");
            isProducing = false;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d/%d", name, actualAmount, totalAmount);
    }
}

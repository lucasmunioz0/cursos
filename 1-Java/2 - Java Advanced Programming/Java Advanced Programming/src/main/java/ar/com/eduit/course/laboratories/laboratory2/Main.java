package ar.com.eduit.course.laboratories.laboratory2;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Water Bottle", 70);
        Consumer consumer = new Consumer(product);
        Producer producer = new Producer(product);
        new Thread(consumer).start();
        new Thread(producer).start();
    }
}

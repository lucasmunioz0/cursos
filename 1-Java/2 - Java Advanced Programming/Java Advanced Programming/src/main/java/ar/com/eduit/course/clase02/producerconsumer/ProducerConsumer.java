package ar.com.eduit.course.clase02.producerconsumer;

public class ProducerConsumer {
    public static void main(String[] args) {
        Product producto = new Product();
        Consumer consumidor = new Consumer(producto, 10);
        Producer productor = new Producer(producto, 10);
        consumidor.start();
        productor.start();
    }
}

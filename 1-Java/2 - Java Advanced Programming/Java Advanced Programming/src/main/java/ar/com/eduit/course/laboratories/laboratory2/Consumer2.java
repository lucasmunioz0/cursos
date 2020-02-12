package ar.com.eduit.course.laboratories.laboratory2;

public class Consumer2 implements Runnable {

    private Product2 product;

    public Consumer2(Product2 product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Consuming...");
            product.consume((int) (Math.random() * 10));
            System.out.println(product);
        }
    }
}

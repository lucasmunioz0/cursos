package ar.com.eduit.course.laboratories.laboratory2;

public class Producer2 implements Runnable {

    private Product2 product;

    public Producer2(Product2 product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Producing...");
            product.produce((int) (Math.random() * 10));
            System.out.println(product);
        }
    }
}

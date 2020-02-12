package ar.com.eduit.course.laboratories.laboratory2;

public class Consumer implements Runnable{
    
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while(true){
            product.consume(10);
        }
    }
}

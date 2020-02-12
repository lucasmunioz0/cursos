package ar.com.eduit.course.laboratories.laboratory2;

public class Producer implements Runnable{
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while(true){
            product.produce(10);
        }
    }
}
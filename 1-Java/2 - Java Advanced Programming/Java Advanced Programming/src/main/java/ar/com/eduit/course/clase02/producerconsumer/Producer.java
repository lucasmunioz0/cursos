package ar.com.eduit.course.clase02.producerconsumer;

public class Producer extends Thread{

    private Product producto;
    private int cantidad;

    public Producer(Product producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    @Override
    public void run() {
        while(true){
            producto.producir(cantidad);
        }
    }
    
}

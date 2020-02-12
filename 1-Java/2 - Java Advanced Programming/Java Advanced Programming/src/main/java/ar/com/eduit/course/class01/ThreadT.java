package ar.com.eduit.course.class01;

public class ThreadT extends Thread{
    private String nombre;

    public ThreadT(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        //Este método puede ejecutarse en nuevo Thread
        for(int i = 1; i <= 10; i++){
            try {
                System.out.println(String.format("%s %d", nombre, i));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }    
}
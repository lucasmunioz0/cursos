package ar.com.eduit.course.class02;

public class Saludo {

    public synchronized void saludoJefe() {
        System.out.println("JEFE>Buenos días!");
        notifyAll();
    }

    public synchronized void esperarJefe(String empleado) {
        try{
            wait();
            System.out.println(empleado + " > Buenos días JEFE!");
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
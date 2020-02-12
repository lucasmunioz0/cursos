package ar.com.eduit.course.class02;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Saludo saludo = new Saludo();
        Personal pablo = new Personal("pablo", saludo, false);
        Personal luis = new Personal("luis", saludo, false);
        Personal andrea = new Personal("andrea", saludo, false);
        Personal pedro = new Personal("pedro", saludo, false);
        Personal jefe = new Personal("Jefe", saludo, true);

//        pablo.join();
//        luis.join();
//        andrea.join();
//        pedro.join();
//        jefe.join();


        new Streams(andrea).
        pablo.start();
        luis.start();
        andrea.start();
        pedro.start();
        jefe.start();
    }
}

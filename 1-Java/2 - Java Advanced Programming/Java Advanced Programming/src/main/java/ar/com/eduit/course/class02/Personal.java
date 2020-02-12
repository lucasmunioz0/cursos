package ar.com.eduit.course.class02;

public class Personal extends Thread{
    private String nombre;
    private Saludo saludo;
    private boolean esJefe;

    public Personal() {
    }

    public Personal(String nombre, Saludo saludo, boolean esJefe) {
        this.nombre = nombre;
        this.saludo = saludo;
        this.esJefe = esJefe;
    }

    @Override
    public void run() {
        System.out.println(String.format("(%s) llega", nombre));
        if(esJefe){
            saludo.saludoJefe();
        }else{
            saludo.esperarJefe(this.nombre);
        }
    }
}
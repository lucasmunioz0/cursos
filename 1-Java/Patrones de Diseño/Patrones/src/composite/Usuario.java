package composite;

public class Usuario implements Composite{
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void enviarMail() {
        System.out.println("Se envio el email: " + nombre);
    }
}
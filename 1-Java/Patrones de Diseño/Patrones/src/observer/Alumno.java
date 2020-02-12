package observer;

import java.util.LinkedList;
import java.util.List;

public class Alumno implements Observator{
    private List<Observer> observers = new LinkedList<>();

    private Long id;
    private String nombre;
    private String apellido;

    public Alumno() {
    }

    public Alumno(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        notificar(this);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        notificar(this);
    }
    
    @Override
    public void notificar(Object event){
        observers.forEach(vista -> vista.imprimir(event));
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    public void attach(Observer observer){
        observers.add(observer);
    }
    
    public void detach(Observer observer){
        observers.remove(observer);
    }
}
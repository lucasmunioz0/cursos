package builder;

import memento.*;
import java.util.LinkedList;
import java.util.List;

public class Alumno {

    private Long id;
    private String nombre;
    private String apellido;
    private List<AlumnoMemento> mementos = new LinkedList<>();

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
        addMemento();
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        addMemento();
        this.apellido = apellido;
    }

    public void undo() {
        if (!mementos.isEmpty()) {
            AlumnoMemento memento = mementos.remove(mementos.size() - 1);
            this.nombre = memento.getNombre();
            this.apellido = memento.getApellido();
        }
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    private void addMemento(){
        if(mementos.size() > 10){
            mementos.remove(mementos.size() - 1);
            mementos.add(new AlumnoMemento(this.nombre, apellido));
        }
    }
}

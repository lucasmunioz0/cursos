/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Curso {
    private String nombre;
    private Set<Alumno> alumnos = new HashSet<>();

    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }
    
    public void inscribir(Alumno almuno){
        alumnos.add(almuno);
    }
    
    public Iterator<Alumno> iterator(){
        return new AlumnosIterator(alumnos);
    }
    
    public Iterator<Alumno> iteratorReverse(){
        return new AlumnosIteratorReverse(alumnos);
    }
}

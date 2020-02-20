/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proxy;

import java.util.LinkedList;
import java.util.List;


public class Alumno {
    private String nombre;
    private List<Curso> cursos = new LinkedList<>();

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", cursos=" + cursos + '}';
    }
    
    
    
    
}

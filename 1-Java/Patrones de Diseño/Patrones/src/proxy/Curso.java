/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proxy;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Curso {
    private Usuario profesor;
    private String nombre;
    private Date fecha = new Date();
    private List<Alumno> alumno = new LinkedList<>();

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }    

    public List<Alumno> getAlumno() {
        return alumno;
    }
}
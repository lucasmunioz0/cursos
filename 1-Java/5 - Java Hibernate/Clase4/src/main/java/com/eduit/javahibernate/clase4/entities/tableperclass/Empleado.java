package com.eduit.javahibernate.clase4.entities.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado extends Persona {
    @Column(name = "em_sueldo")
    private Double sueldo;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, Double sueldo) {
        super(nombre, apellido);
        this.sueldo = sueldo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + " Empleado{" +
                "sueldo=" + sueldo +
                '}';
    }
}

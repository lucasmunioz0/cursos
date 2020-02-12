package ar.com.educacionit.patrones.main;

import ar.com.educacionit.patrones.actores.Cliente;
import ar.com.educacionit.patrones.actores.Empleado;
import ar.com.educacionit.patrones.actores.Persona;
import ar.com.educacionit.patrones.actores.Socio;

public class Main {

    public static void main(String[] args) {
        Persona p = new Cliente(12121);
        System.out.println("El cliente dice: ");
        System.out.println(p.identificate());

        System.out.println("El empleado dice: ");
        p = new Empleado("AD 41252");
        System.out.println(p.identificate());

        System.out.println("El socio dice: ");
        p = new Socio(46232);
        System.out.println(p.identificate());
    }
}

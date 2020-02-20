/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package observer;


public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno(24L, "Lucas", "Muñoz");
        alumno.attach(new Vista1Alumno());
        alumno.attach(new Vista2Alumno());
        alumno.setApellido("Illobre");
        alumno.setNombre("Carlos");
        alumno.setNombre("Gustavo");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iterator;

import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Carlos");
        Alumno alumno2 = new Alumno("Gustavo");
        Curso curso = new Curso("PHP");
        curso.inscribir(alumno1);
        curso.inscribir(alumno2);
        
        Iterator<Alumno> iterator = curso.iterator();
        
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

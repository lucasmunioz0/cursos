/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flyweight;


public class Main {
    public static void main(String[] args) {
        DaoLocator.getAlumnoDao().crearAlumno("Carlos");

        DaoLocator.getAlumnoDao().borrarAlumno("Carlos");
    }
}
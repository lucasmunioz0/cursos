/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

public class Vista1Alumno implements Observer{

    @Override
    public void imprimir(Object alumno) {
        System.out.println(alumno);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class AlumnosIteratorReverse implements Iterator<Alumno> {
    private List<Alumno> alumnos;
    private int index;    

    public AlumnosIteratorReverse(Collection<Alumno> alumnos) {
        this.alumnos = new ArrayList(alumnos);
        this.index = alumnos.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Alumno next() {
        return alumnos.get(index--);        
    }
}
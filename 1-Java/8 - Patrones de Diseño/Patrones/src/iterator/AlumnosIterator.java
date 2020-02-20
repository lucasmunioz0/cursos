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
import java.util.Set;


public class AlumnosIterator implements Iterator{

    private List<Alumno> alumnos;
    private int index = 0;    
    
    public AlumnosIterator() {
    }

    public AlumnosIterator(Collection<Alumno> alumnos) {
        alumnos = new ArrayList<>(alumnos);
    }    

    @Override
    public boolean hasNext() {
        return index < alumnos.size();
    }

    @Override
    public Object next() {
        return alumnos.get(index++);
    }
}
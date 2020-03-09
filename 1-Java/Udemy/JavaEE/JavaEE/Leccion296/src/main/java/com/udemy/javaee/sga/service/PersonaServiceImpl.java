package com.udemy.javaee.sga.service;

import com.udemy.javaee.sga.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> getAll() {
        final List<Persona> people = new ArrayList<>();
        people.add(new Persona(1, "Juan", "Perez", "jperez@gmail.com", "35335123"));
        people.add(new Persona(1, "Maria", "Castro", "mcastro@gmail.com", "649846"));
        people.add(new Persona(1, "Jose", "Fernandez", "jfernandez@gmail.com", "64986456"));
        people.add(new Persona(1, "Marta", "Guines", "mguines@gmail.com", "6544654"));
        return people;
    }

    @Override
    public Persona findById(Persona persona) {
        return null;
    }

    @Override
    public Persona findByEmail(Persona persona) {
        return null;
    }

    @Override
    public void insert(Persona persona) {
        
    }

    @Override
    public void update(Persona persona) {
        
    }

    @Override
    public void delete(Persona persona) {
        
    }    
}
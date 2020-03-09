package com.udemy.javaee.sga.service;

import java.util.List;
import javax.ejb.Local;
import com.udemy.javaee.sga.domain.Persona;

@Local
public interface PersonaService {
    public List<Persona> getAll();

    public Persona findById(Persona persona);

    public Persona findByEmail(Persona persona);

    public void insert(Persona persona);

    public void update(Persona persona);

    public void delete(Persona persona);
}

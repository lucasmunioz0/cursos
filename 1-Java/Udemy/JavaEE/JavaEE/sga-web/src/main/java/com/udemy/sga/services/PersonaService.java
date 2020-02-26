package com.udemy.sga.services;

import com.udemy.sga.domain.Persona;
import java.util.List;

public interface PersonaService {
    public List<Persona> findAll();
    public Persona getById(Persona persona);
    public Persona getByEmail(Persona persona);
    public void insert(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
}

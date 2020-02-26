package com.udemy.javaee.sga.dal;

import java.util.List;
import com.udemy.javaee.sga.domain.Persona;

public interface PersonaDao {
    public List<Persona> findAll();
    public Persona getById(Persona persona);
    public Persona getByEmail(Persona persona);
    public void insert(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
}

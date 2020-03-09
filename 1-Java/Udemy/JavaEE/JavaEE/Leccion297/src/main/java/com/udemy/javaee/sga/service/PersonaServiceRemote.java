package com.udemy.javaee.sga.service;

import com.udemy.javaee.sga.domain.Persona;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PersonaServiceRemote {

    public List<Persona> getAll();

    public Persona findById(Persona persona);

    public Persona findByEmail(Persona persona);

    public void insert(Persona persona);

    public void update(Persona persona);

    public void delete(Persona persona);
}

package com.udemy.angular.dal.dao;

import com.udemy.angular.domains.Persona;
import java.util.List;

public interface PersonaDao {
    public List<Persona> findAll();
    public Persona findById(Persona persona);
    public void insert(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
}

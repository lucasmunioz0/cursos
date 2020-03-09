package com.udemy.javaee.sga.service;

import com.udemy.javaee.sga.dal.PersonaDao;
import com.udemy.javaee.sga.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{
    
    @Inject
    private PersonaDao dao;

    @Override
    public List<Persona> getAll() {
        return dao.findAll();
    }

    @Override
    public Persona findById(Persona persona) {
        return dao.getById(persona);
    }

    @Override
    public Persona findByEmail(Persona persona) {
        return dao.getByEmail(persona);
    }

    @Override
    public void insert(Persona persona) {
        dao.insert(persona);
    }

    @Override
    public void update(Persona persona) {
        dao.update(persona);
    }

    @Override
    public void delete(Persona persona) {
        dao.delete(persona);
    }    
}
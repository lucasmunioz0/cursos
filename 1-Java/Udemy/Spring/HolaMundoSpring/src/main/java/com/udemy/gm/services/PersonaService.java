package com.udemy.gm.services;

import com.udemy.gm.dal.IPersonaDao;
import com.udemy.gm.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private IPersonaDao repository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) repository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        repository.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        repository.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona getById(Persona persona) {
        return repository.findById(persona.getId()).orElse(null);
    }
}

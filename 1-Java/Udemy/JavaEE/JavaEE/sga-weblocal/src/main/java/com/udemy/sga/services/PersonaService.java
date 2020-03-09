package com.udemy.sga.services;

import com.udemy.sga.domain.Persona;

public interface PersonaService extends BaseService<Persona>{
    public Persona getByEmail(Persona persona);
}

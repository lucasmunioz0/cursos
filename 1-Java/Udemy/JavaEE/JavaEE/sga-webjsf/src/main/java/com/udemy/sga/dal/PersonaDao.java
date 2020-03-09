package com.udemy.sga.dal;

import com.udemy.sga.domain.Persona;

public interface PersonaDao extends BaseDao<Persona>{
    public Persona getByEmail(Persona persona);
}

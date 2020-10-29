package com.udemy.gm.services;

import com.udemy.gm.domain.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> listarPersonas();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona getById(Persona persona);
}

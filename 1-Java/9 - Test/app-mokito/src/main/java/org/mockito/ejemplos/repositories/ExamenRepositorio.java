package org.mockito.ejemplos.repositories;

import org.mockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepositorio {
    List<Examen> findAll();
}

package org.mockito.ejemplos.repositories;

import java.util.List;

public interface PreguntasRepositorio {
    List<String> findPreguntasPorExamenId(Long id);
    void guardarVarias(List<String> preguntas);
}

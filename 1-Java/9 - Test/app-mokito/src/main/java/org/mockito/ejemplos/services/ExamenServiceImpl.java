package org.mockito.ejemplos.services;

import org.mockito.ejemplos.models.Examen;
import org.mockito.ejemplos.repositories.ExamenRepositorio;
import org.mockito.ejemplos.repositories.PreguntasRepositorio;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService {

    private ExamenRepositorio examenRepositorio;
    private PreguntasRepositorio preguntasRepositorio;

    public ExamenServiceImpl(ExamenRepositorio examenRepositorio, PreguntasRepositorio preguntasRepositorio){
        this.examenRepositorio = examenRepositorio;
        this.preguntasRepositorio = preguntasRepositorio;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(final String nombre) {
        return examenRepositorio.findAll()
                .stream()
                .filter(ex -> ex.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if(examenOptional.isPresent()){
            examen = examenOptional.orElseThrow();
            var preguntas = preguntasRepositorio.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }

        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {
        if(!examen.getPreguntas().isEmpty()){
            preguntasRepositorio.guardarVarias(examen.getPreguntas());
        }

        return examenRepositorio.guardar(examen);
    }
}

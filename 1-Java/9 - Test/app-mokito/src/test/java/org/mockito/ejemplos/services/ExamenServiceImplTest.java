package org.mockito.ejemplos.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ejemplos.models.Examen;
import org.mockito.ejemplos.repositories.ExamenRepositorio;
import org.mockito.ejemplos.repositories.PreguntasRepositorio;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExamenServiceImplTest {

    ExamenService examenService;
    ExamenRepositorio examenRepositorio;
    PreguntasRepositorio preguntasRepositorio;

    @BeforeEach
    void setUp(){
        examenRepositorio = mock(ExamenRepositorio.class);
        preguntasRepositorio = mock(PreguntasRepositorio.class);
        examenService = new ExamenServiceImpl(examenRepositorio, preguntasRepositorio);
    }

    @Test
    void findExamenPorNombre() {
        when(examenRepositorio.findAll()).thenReturn(Arrays.asList(
                new Examen(5L, "Matemáticas"),
                new Examen(6L, "Lenguaje"),
                new Examen(8L, "Geografía")));

        var examen = examenService.findExamenPorNombre("Matemáticas");
        assertAll(
                () -> assertTrue(examen.isPresent()),
                () -> assertEquals(5L, examen.orElseThrow().getId()),
                () -> assertEquals("Matemáticas", examen.get().getNombre())
        );
    }

    @Test
    void findExamenPorNombreEmpty() {
        when(examenRepositorio.findAll()).thenReturn(Collections.emptyList());

        var examen = examenService.findExamenPorNombre("Matemáticas");
         assertFalse(examen.isPresent());
    }
}
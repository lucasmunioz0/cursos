package org.mockito.ejemplos.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.ejemplos.models.Examen;
import org.mockito.ejemplos.repositories.ExamenRepositorio;
import org.mockito.ejemplos.repositories.PreguntasRepositorio;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {

    @Mock
    ExamenRepositorio examenRepositorio;
    @Mock
    PreguntasRepositorio preguntasRepositorio;

    @InjectMocks
    ExamenServiceImpl examenService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findExamenPorNombre() {
        given(examenRepositorio.findAll()).willReturn(Datos.EXAMENES);

        var examen = examenService.findExamenPorNombre("Matemáticas");
        assertAll(
                () -> assertTrue(examen.isPresent()),
                () -> assertEquals(5L, examen.orElseThrow().getId()),
                () -> assertEquals("Matemáticas", examen.get().getNombre())
        );
    }

    @Test
    void findExamenPorNombreEmpty() {
        given(examenRepositorio.findAll()).willReturn(Collections.emptyList());

        var examen = examenService.findExamenPorNombre("Matemáticas");
        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        given(examenRepositorio.findAll()).willReturn(Datos.EXAMENES);
        given(preguntasRepositorio.findPreguntasPorExamenId(anyLong())).willReturn(Datos.PREGUNTAS);

        var examen = examenService.findExamenPorNombreConPreguntas("Lenguaje");

        assertAll(
                () -> assertNotNull(examen),
                () -> assertEquals(examen.getNombre(), "Lenguaje"),
                () -> assertEquals(5, examen.getPreguntas().size())
        );
    }

    @Test
    void testPreguntasExamenVerify() {
        given(examenRepositorio.findAll()).willReturn(Datos.EXAMENES);
        given(preguntasRepositorio.findPreguntasPorExamenId(anyLong())).willReturn(Datos.PREGUNTAS);
        var examen = examenService.findExamenPorNombreConPreguntas("Lenguaje");

        assertAll(
                () -> assertNotNull(examen),
                () -> assertEquals(examen.getNombre(), "Lenguaje"),
                () -> assertEquals(5, examen.getPreguntas().size()),
                () -> verify(examenRepositorio).findAll(),
                () -> verify(preguntasRepositorio).findPreguntasPorExamenId(anyLong())
        );
    }

    @Test
    void insertExamen() {
        var nuevoExamen = Datos.EXAMEN;
        nuevoExamen.setPreguntas(Datos.PREGUNTAS);

        given(examenRepositorio.guardar(any(Examen.class))).willReturn(Datos.EXAMEN);
        var examen = examenService.guardar(nuevoExamen);

        assertAll(
                () -> assertNotNull(examen.getId()),
                () -> assertEquals(8L, examen.getId()),
                () -> assertEquals("Física", examen.getNombre()),

                () -> verify(examenRepositorio).guardar(any(Examen.class)),
                () -> verify(preguntasRepositorio).guardarVarias(anyList())
        );
    }
}
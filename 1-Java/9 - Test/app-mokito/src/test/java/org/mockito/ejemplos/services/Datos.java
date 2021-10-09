package org.mockito.ejemplos.services;

import org.mockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public static final List<Examen> EXAMENES = Arrays.asList(
            new Examen(5L, "Matemáticas"),
            new Examen(6L, "Lenguaje"),
            new Examen(8L, "Geografía"));

    public static final List<String> PREGUNTAS = Arrays.asList(
            "aritmetica", "integrales", "derivadas", "trigonometria", "geometria");

    public static final Examen EXAMEN = new Examen(null, "Física");
}

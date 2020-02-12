package com.eduit;

import com.eduit.javahibernate.clase4.entities.Cliente;
import com.eduit.javahibernate.clase4.entities.Empleado;
import com.eduit.javahibernate.clase4.entities.Persona;
import com.eduit.javahibernate.clase4.manager.SessionFactoryManager;
import com.eduit.javahibernate.clase4.repository.PersonaRepository;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PersonaRepositoryTest {

    private SessionFactory sessionFactory;

    @Before
    public void before(){
        sessionFactory = SessionFactoryManager.getSessionFactory();
    }

    @After
    public void after(){
        sessionFactory.close();
    }

    @Test
    public void singleTableTest() {
        final PersonaRepository personaRepository = new PersonaRepository(sessionFactory);

        Persona persona = new Persona("Lucas", "Muñoz");
        Persona cliente = new Cliente("Lucas Cliente", "Muñoz", 6500D);
        Persona empleado = new Empleado("Lucas Empleado", "Empleado", 50000D);

        personaRepository.save(persona);
        personaRepository.save(cliente);
        personaRepository.save(empleado);

        final List<Persona> personas = personaRepository.get();
        personas.forEach(System.out::println);
        final List<Persona> clientes = personaRepository.getClientes();
        clientes.forEach(System.out::println);
    }
}

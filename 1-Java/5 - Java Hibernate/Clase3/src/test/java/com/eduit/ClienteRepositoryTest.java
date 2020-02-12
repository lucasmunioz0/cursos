package com.eduit;

import com.ar.eduit.javahibernate.clase3.entities.Cliente;
import com.ar.eduit.javahibernate.clase3.entities.dtos.MaxCreditReport;
import com.ar.eduit.javahibernate.clase3.manager.SessionFactoryManager;
import com.ar.eduit.javahibernate.clase3.repository.ClienteRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

public class ClienteRepositoryTest {

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
    public void shouldSaveAClient(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 85000D);
        final Long id = clienteRepository.save(cliente);
        cliente = clienteRepository.getById(id);
        Assert.assertEquals("Lucas", cliente.getNombre());
        Assert.assertEquals("Muñoz", cliente.getApellido());
        Assert.assertEquals(new Double(85000), cliente.getCredito());
    }
    @Test
    public void shouldTestAllCRUD(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 85000D);
        final Long id = clienteRepository.save(cliente);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 10000D);
        final Long id2 = clienteRepository.save(cliente2);

        cliente = clienteRepository.getById(id);
        Assert.assertEquals("Lucas", cliente.getNombre());
        Assert.assertEquals("Muñoz", cliente.getApellido());
        Assert.assertEquals(new Double(85000), cliente.getCredito());

        cliente2.setNombre("pepe");
        clienteRepository.update(cliente2);
        cliente2 = clienteRepository.getById(id2);
        Assert.assertEquals("pepe", cliente2.getNombre());

        List<Cliente> clientes = clienteRepository.get();
        Assert.assertEquals(2, clientes.size());

        clienteRepository.delete(cliente);
        clienteRepository.delete(cliente2);

        clientes = clienteRepository.get();
        Assert.assertEquals(0, clientes.size());
    }
    @Test
    public void shouldGetTest(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 85000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 10000D);
        Cliente cliente3 = new Cliente("Pepe", "Perez", 20000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        List<Cliente> clientes = clienteRepository.getByName("Lucas");
        clientes.forEach(System.out::println);

        clientes = clienteRepository.getByNameAndLastName("Pepe", "Perez");
        clientes.forEach(System.out::println);
        Assert.assertEquals("Pepe", clientes.get(0).getNombre());
    }

    @Test
    public void shouldGetMaxCredit(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 85000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 10000D);
        Cliente cliente3 = new Cliente("Pepe", "Perez", 20000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        Double max = clienteRepository.maxCredito();
        Assert.assertEquals(new Double(85000D), max);
    }

    @Test
    public void shouldGetQuantity(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 85000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 10000D);
        Cliente cliente3 = new Cliente("Pepe", "Perez", 20000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        Long quantity = clienteRepository.count();
        Assert.assertEquals(new Long(3), quantity);
    }

    @Test
    public void shouldGetAverage(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 25000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 20000D);
        Cliente cliente3 = new Cliente("Pepe", "Perez", 15000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        Double average = clienteRepository.average();
        Assert.assertEquals(new Double(20000), average);
    }

    @Test
    public void shouldGetAllNames(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 25000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 20000D);
        Cliente cliente3 = new Cliente("Juan", "Perez", 15000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        List<String> nombres = clienteRepository.getAllNames();
        nombres.forEach(System.out::println);
        Assert.assertEquals("Lucas", nombres.get(0));
        Assert.assertEquals("Pepe", nombres.get(1));
        Assert.assertEquals("Juan", nombres.get(2));
    }
    @Test
    public void shouldGetAllNamesAndLastNames(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 25000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 20000D);
        Cliente cliente3 = new Cliente("Juan", "Perez", 15000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        List<Object[]> nombresCompletos = clienteRepository.getAllNamesAndLastName();
        nombresCompletos.forEach(o ->{
            System.out.println("Nombre: " + o[0] + ", Apellido: " + o[1]);
        });

        Assert.assertEquals("Lucas", nombresCompletos.get(0)[0]);
        Assert.assertEquals("Muñoz", nombresCompletos.get(0)[1]);
        Assert.assertEquals("Pepe", nombresCompletos.get(1)[0]);
        Assert.assertEquals("Perez", nombresCompletos.get(1)[1]);
        Assert.assertEquals("Juan", nombresCompletos.get(2)[0]);
        Assert.assertEquals("Perez", nombresCompletos.get(2)[1]);
    }

    @Test
    public void shouldGetNameAndCreditFromMaxCredit(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 25000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 20000D);
        Cliente cliente3 = new Cliente("Juan", "Perez", 15000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        List<Object[]> nombresCompletos = clienteRepository.getNameAndCreditFromMaxCredit();
        nombresCompletos.forEach(o ->{
            System.out.println("Nombre: " + o[0] + ", Credito: " + o[1]);
        });

        Assert.assertEquals("Lucas", nombresCompletos.get(0)[0]);
        Assert.assertEquals(new Double(25000), nombresCompletos.get(0)[1]);
    }

    @Test
    public void shouldGetNameAndCreditFromMaxCreditWithDto(){
        final ClienteRepository clienteRepository = new ClienteRepository(sessionFactory);
        Cliente cliente = new Cliente("Lucas", "Muñoz", 25000D);
        Cliente cliente2 = new Cliente("Pepe", "Perez", 20000D);
        Cliente cliente3 = new Cliente("Juan", "Perez", 15000D);
        clienteRepository.save(cliente);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);
        List<MaxCreditReport> nombresCompletos = clienteRepository.getNameAndCreditFromMaxCreditWithDto();
        nombresCompletos.forEach(System.out::println);

        Assert.assertEquals("Lucas", nombresCompletos.get(0).getNombre());
        Assert.assertEquals(new Double(25000), nombresCompletos.get(0).getCredito());
    }
}

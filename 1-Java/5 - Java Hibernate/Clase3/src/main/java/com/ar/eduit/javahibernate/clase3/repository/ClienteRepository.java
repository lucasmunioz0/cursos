package com.ar.eduit.javahibernate.clase3.repository;

import com.ar.eduit.javahibernate.clase3.entities.Cliente;
import com.ar.eduit.javahibernate.clase3.entities.dtos.MaxCreditReport;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteRepository {
    private SessionFactory sessionFactory;

    public ClienteRepository(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new NullPointerException("sessionFactory is mandatory");
        }
        this.sessionFactory = sessionFactory;
    }

    public Cliente getById(Long id) {
        Session session = sessionFactory.openSession();
        Cliente cliente = session.get(Cliente.class, id);
        session.close();
        return cliente;
    }

    public Long save(Cliente cliente) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            final Long id = (Long) session.save(cliente);
            tx.commit();
            session.close();
            return id;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void update(Cliente cliente) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.update(cliente);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(Cliente cliente) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.delete(cliente);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public List<Cliente> get() {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("FROM Cliente ");
        final List<Cliente> clientes = query.list();
        session.close();
        return clientes;
    }

    public List<Cliente> getByName(String name) {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("FROM Cliente WHERE nombre = :nombre");
        query.setParameter("nombre", name);

        final List<Cliente> clientes = query.list();
        session.close();
        return clientes;
    }
    public List<Cliente> getByNameAndLastName(String name, String apellido) {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("FROM Cliente WHERE nombre = :nombre and apellido = :apellido");
        query.setParameter("nombre", name);
        query.setParameter("apellido", apellido);

        final List<Cliente> clientes = query.list();
        session.close();
        return clientes;
    }

    public Double maxCredito() {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("Select max(credito) FROM Cliente ");
        final Double creditoMaximo = (Double) query.uniqueResult();
        session.close();
        return creditoMaximo;
    }

    public Long count() {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("Select count(1) FROM Cliente ");
        final Long cantidad = (Long) query.uniqueResult();
        session.close();
        return cantidad;
    }

    public Double average() {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("Select avg(credito) FROM Cliente ");
        final Double average = (Double) query.uniqueResult();
        session.close();
        return average;
    }

    public List<String> getAllNames(){
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("Select nombre FROM Cliente ");
        final List<String> nombres = query.list();
        session.close();
        return nombres;
    }

    public List<Object[]> getAllNamesAndLastName(){
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("Select nombre, apellido FROM Cliente ");
        final List<Object[]> nombresCompletos = query.list();
        session.close();
        return nombresCompletos;
    }

    public List<Object[]> getNameAndCreditFromMaxCredit(){
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("Select nombre, credito FROM Cliente order by credito desc");
        query.setMaxResults(1);
        final List<Object[]> nombresCompletos = query.list();
        session.close();
        return nombresCompletos;
    }

    public List<MaxCreditReport> getNameAndCreditFromMaxCreditWithDto(){
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("Select new com.ar.eduit.javahibernate.clase3.entities.dtos.MaxCreditReport(nombre, credito) FROM Cliente order by credito desc");
        query.setMaxResults(1);
        final List<MaxCreditReport> nombresCompletos = query.list();
        session.close();
        return nombresCompletos;
    }
}

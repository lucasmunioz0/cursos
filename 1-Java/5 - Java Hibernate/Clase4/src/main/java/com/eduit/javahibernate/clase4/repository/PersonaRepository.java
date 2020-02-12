package com.eduit.javahibernate.clase4.repository;

import com.eduit.javahibernate.clase4.entities.Persona;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonaRepository {
    private SessionFactory sessionFactory;

    public PersonaRepository(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new NullPointerException("sessionFactory is mandatory");
        }
        this.sessionFactory = sessionFactory;
    }

    public Persona getById(Long id) {
        Session session = sessionFactory.openSession();
        Persona persona = session.get(Persona.class, id);
        session.close();
        return persona;
    }

    public Long save(Persona persona) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            final Long id = (Long) session.save(persona);
            tx.commit();
            session.close();
            return id;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void update(Persona persona) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.update(persona);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public void delete(Persona persona) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            session.delete(persona);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        }
    }

    public List<Persona> get() {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("FROM Persona ");
        final List<Persona> personas = query.list();
        session.close();
        return personas;
    }

    public List<Persona> getClientes() {
        final Session session = sessionFactory.openSession();
        final Query query = session.createQuery("FROM Cliente ");
        final List<Persona> personas = query.list();
        session.close();
        return personas;
    }
}

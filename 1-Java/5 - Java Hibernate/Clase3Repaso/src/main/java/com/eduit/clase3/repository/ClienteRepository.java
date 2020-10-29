package com.eduit.clase3.repository;

import com.eduit.clase3.entities.Cliente;
import java.util.List;
//import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ClienteRepository {

    private SessionFactory sessionFactory;

    public ClienteRepository(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new NullPointerException(" sessionFactory is mandatory.");
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
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Long id = (Long) session.save(cliente);
            tx.commit();
            return id;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public void update(Cliente cliente) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(cliente);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public void delete(Cliente cliente) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(cliente);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Cliente> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Cliente");
        session.close();
        return query.getResultList();
    }
    
    public List<Cliente> getByname(String name){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Cliente WHERE nombre = :nombre");
        query.setParameter("nombre", name);
        return query.list();
    }
}

package com.udemy.javaee.sga.dal;

import com.udemy.javaee.sga.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless 
public class PersonaDaoImpl implements PersonaDao{
    
    @PersistenceContext(unitName="PersonaPU")
    EntityManager em;

    @Override
    public List<Persona> findAll() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona getById(Persona persona) {
        return em.find(Persona.class, persona.getId());
    }

    @Override
    public Persona getByEmail(Persona persona) {
        Query query = em.createQuery("FROM Persona p WHERE p.email = :email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insert(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void update(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void delete(Persona persona) {
        em.remove(em.merge(persona));
    }
    
}

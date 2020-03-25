package com.udemy.angular.dal.impl;

import com.udemy.angular.dal.dao.PersonaDao;
import com.udemy.angular.domains.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PersonaDaoImpl implements PersonaDao{

     @PersistenceContext(unitName = "PersonaPU")
     private EntityManager em;
    
    @Override
    public List<Persona> findAll() {         
         return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public void insert(Persona persona) {
        em.persist(persona);
        em.flush();
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

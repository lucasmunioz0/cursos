package com.udemy.sga.criteria;

import com.udemy.sga.domain.Persona;
import com.udemy.sga.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PruebaApiCriteria {
    private static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder builder = null;
        CriteriaQuery<Persona> query = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> select = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        log.debug("\n\t\t1.Consulta de todas las personas");
        builder = em.getCriteriaBuilder();
        query = builder.createQuery(Persona.class);
        fromPersona = query.from(Persona.class);
        query.select(fromPersona);
        select = em.createQuery(query);
        personas = select.getResultList();
        mostrarPersonas(personas);
        
        log.debug("\n\t\t2-a.Consulta de la Persona con id = 2");
        builder = em.getCriteriaBuilder();
        query = builder.createQuery(Persona.class);
        fromPersona = query.from(Persona.class);
        query.select(fromPersona).where(builder.equal(fromPersona.get("idPersona"), 8L));        
        select = em.createQuery(query);
        persona = select.getSingleResult();
        log.debug(persona);
        
        log.debug("\n\t\t2-b.Consulta de la Persona con id = 8 usando Predicates");
        builder = em.getCriteriaBuilder();
        query = builder.createQuery(Persona.class);
        fromPersona = query.from(Persona.class);
        query.select(fromPersona);
        //La clase Predicate
        List<Predicate> criterios = new ArrayList<>();
        Integer idPersona = 8;
        
        ParameterExpression<Integer> parameter = builder.parameter(Integer.class, "idPersona");
        criterios.add(builder.equal(fromPersona.get("idPersona"), parameter));
        
        if(criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        }else if(criterios.size() == 1){
            query.where(criterios.get(0));
        }else{
            query.where(builder.and(criterios.toArray(new Predicate[0])));
        }
        select = em.createQuery(query);
        select.setParameter("idPersona", idPersona);        
        persona = select.getSingleResult();
        log.debug(persona);
    }
    
    private static void mostrarPersonas(List<Persona> personas) {
        log.debug("\n\t\tPersonas");
        personas.forEach(log::debug);
    }
    
    private static void mostrarUsuarios(List<Usuario> usuarios) {
        log.debug("\n\t\tPersonas");
        usuarios.forEach(log::debug);
    }
}

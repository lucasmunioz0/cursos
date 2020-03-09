
package com.udemy.sga.ciclovidajpa;

import com.udemy.sga.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;


public class EliminarObjetoJPA {
    private static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();  
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persona persona = em.find(Persona.class, 1);
        
        em.remove(persona);
        
        //em.merge(persona);
        tx.commit();
        log.debug("Estado detached: " + persona);       
        
        em.close();
        
        
    }
}

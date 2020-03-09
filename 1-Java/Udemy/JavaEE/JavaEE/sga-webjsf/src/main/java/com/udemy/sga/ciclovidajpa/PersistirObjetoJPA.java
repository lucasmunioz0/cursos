
package com.udemy.sga.ciclovidajpa;

import com.udemy.sga.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;


public class PersistirObjetoJPA {
    private static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        //Paso 1 crear objeto en estado Transitivo
        Persona persona = new Persona("Lucas", "Muñoz", "lmunoz@gmail.com", "qeqwe");
        
        tx.begin();
        em.persist(persona);
        
        log.debug("Estado persist: " + persona);
        tx.commit();
        
        log.debug("Estado detached: " + persona);
        
        
        em.close();
        
        
    }
}

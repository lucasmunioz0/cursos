
package com.udemy.sga.ciclovidajpa;

import com.udemy.sga.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;


public class EncontrarObjetoJPA {
    private static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();  
        //Inicia la transaccion
        //Paso 1 crear objeto en estado Transitivo
        Persona persona = em.find(Persona.class, 10);
        
        log.debug("Estado detached: " + persona);
        
        
        em.close();
        
        
    }
}

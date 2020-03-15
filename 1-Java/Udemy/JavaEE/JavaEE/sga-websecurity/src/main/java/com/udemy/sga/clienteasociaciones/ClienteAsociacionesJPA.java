package com.udemy.sga.clienteasociaciones;

import com.udemy.sga.domain.Persona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ClienteAsociacionesJPA {
    private static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        List<Persona> resultList = em.createNamedQuery("Persona.findAll").getResultList();
        em.close();       
        
        resultList.forEach(persona -> {
            log.debug(persona);
            persona.getUsuarioList().forEach(log::debug);
        });
        
    }
}

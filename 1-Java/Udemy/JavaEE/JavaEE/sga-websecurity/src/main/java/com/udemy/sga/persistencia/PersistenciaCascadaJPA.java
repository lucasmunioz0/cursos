package com.udemy.sga.persistencia;

import com.udemy.sga.domain.Persona;
import com.udemy.sga.domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PersistenciaCascadaJPA {
    private static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        Persona p1 = new Persona("Nombre", "Apellido", "email2@gmail.com", "qwe12312");
        Usuario u1 = new Usuario("usuario1", "pepe", p1);
        
        System.out.println("ANTES");
        System.out.println(p1);
        System.out.println(u1);
        
        tx.begin();
        em.persist(u1);
        tx.commit();
        System.out.println("DESPUES");
        System.out.println(p1);
        System.out.println(u1);
        em.close();
    }
}

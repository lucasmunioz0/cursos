package com.sga.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionManager {
    private static EntityManagerFactory emf;
    private EntityManager em;

    private SessionManager() {        
        em = emf.createEntityManager();
    }
    
    public static EntityManager getInstance(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("SgaPU");
        }
        return emf.createEntityManager();
    }
}

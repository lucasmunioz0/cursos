package com.sga.dal.repositories;

import com.sga.dal.SessionManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class BaseRepository<T> {
    protected static EntityManager em;
    
    public BaseRepository(){
        em = SessionManager.getInstance();
    }
    
    public abstract List<T> getAll();
    public abstract T getById(T t);
    
    public void insert(T t){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            em.persist(t);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            throw e;
        }
    }
    public void update(T t){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            em.merge(t);
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            throw e;
        }
    }
    public void delete(T t){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            em.remove(em.merge(t));
            tx.commit();
        }catch(Exception e){
            tx.rollback();
            throw e;
        }
    }
}

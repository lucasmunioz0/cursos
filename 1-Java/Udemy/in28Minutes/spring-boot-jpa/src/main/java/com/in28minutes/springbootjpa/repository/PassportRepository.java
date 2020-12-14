package com.in28minutes.springbootjpa.repository;

import com.in28minutes.springbootjpa.entity.Passport;
import com.in28minutes.springbootjpa.entity.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class PassportRepository {
    @Autowired
    EntityManager em;

    public Passport findById(Long id){
        return em.find(Passport.class, id);
    }

    @Transactional
    public Passport save(Passport passport){
        if(passport.getId() == null || passport.getId() == 0){
            em.persist(passport);;
        }else{
            em.merge(passport);
        }

        return passport;
    }

    @Transactional
    public void deleteById(Long id){
        em.remove(findById(id));
    }
}

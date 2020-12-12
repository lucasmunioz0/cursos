package com.in28minutes.database.databasedemo.jpa;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @Autowired
    private EntityManager em;

    public List<Person> findAll(){
        TypedQuery<Person> query = em.createNamedQuery("find_all_persons", Person.class);

        return query.getResultList();
    }

    public Person findById(int id){
        return em.find(Person.class, id);
    }

    public Person insert(Person person){
        return em.merge(person);
    }

    public Person update(Person person){
        return em.merge(person);
    }

    public void deleteById(int id){
        em.remove(findById(id));
    }

}

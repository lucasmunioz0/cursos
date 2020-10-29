package com.sga.dal.repositories;

import static com.sga.dal.repositories.BaseRepository.em;
import com.sga.domain.Contact;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ContactRepository extends BaseRepository<Contact>{
    
    @Override
    public List<Contact> getAll(){
        Query query = em.createQuery("FROM Contact");
        return query.getResultList();
    }
    
    public Contact getById(Contact contact){
        return em.find(Contact.class, contact.getId());
    }
}

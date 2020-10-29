package com.sga.dal.repositories;

import com.sga.domain.Address;
import java.util.List;
import javax.persistence.Query;

public class AddressRepository extends BaseRepository<Address>{

    @Override
    public List<Address> getAll(){
        Query query = em.createQuery("FROM Address");
        return query.getResultList();
    }
    
    public Address getById(Address address){
        return em.find(Address.class, address.getId());
    }
}

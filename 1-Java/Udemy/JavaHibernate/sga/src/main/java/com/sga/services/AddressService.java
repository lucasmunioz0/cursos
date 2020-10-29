package com.sga.services;

import com.sga.dal.repositories.AddressRepository;
import com.sga.domain.Address;

public class AddressService extends BaseService<Address>{

    public AddressService() {        
        super(new AddressRepository());
    }

    @Override
    public Address getById(Long id) {
        return (Address) repository.getById(new Address(id));
    }
}

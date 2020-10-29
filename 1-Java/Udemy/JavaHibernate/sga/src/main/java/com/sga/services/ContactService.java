package com.sga.services;

import com.sga.dal.repositories.ContactRepository;
import com.sga.domain.Contact;

public class ContactService extends BaseService<Contact>{

    public ContactService() {
        super(new ContactRepository());
    }

    @Override
    public Contact getById(Long id) {
        return (Contact) repository.getById(new Contact(id));
    }
}

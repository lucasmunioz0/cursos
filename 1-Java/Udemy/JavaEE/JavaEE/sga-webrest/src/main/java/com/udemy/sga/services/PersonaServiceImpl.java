package com.udemy.sga.services;

import com.udemy.sga.dal.PersonaDao;
import com.udemy.sga.domain.Persona;
import com.udemy.sga.soap.PersonaServicesWS;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "com.udemy.sga.soap.PersonaServicesWS")
public class PersonaServiceImpl implements PersonaService, PersonaServicesWS{
    @Inject
    private PersonaDao dao;
    
    @Resource
    private SessionContext context;

    @Override
    public List<Persona> findAll() {
        return dao.findAll();
    }

    @Override
    public Persona getById(Persona persona) {
        return dao.getById(persona);
    }

    @Override
    public Persona getByEmail(Persona persona) {
        return dao.getByEmail(persona);
    }

    @Override
    public void insert(Persona persona) {
        dao.insert(persona);
    }

    @Override
    public void update(Persona persona) {
        try{
            dao.update(persona);
        }catch(Throwable e){
            context.setRollbackOnly();
            e.printStackTrace(System.err);
        }        
    }

    @Override
    public void delete(Persona persona) {
        dao.delete(persona);
    }    

    @Override
    public List<Persona> listarPersonas() {
        return dao.findAll();
    }
}
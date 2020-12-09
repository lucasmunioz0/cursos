package com.datajpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.datajpa.domain.Cliente;

@Repository
public class ClienteDao implements IClienteRepository{
	@PersistenceContext
	private EntityManager em;

	@Override	
	public List<Cliente> findAll() {
		return em.createQuery("FROM Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
				
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));		
	}
}

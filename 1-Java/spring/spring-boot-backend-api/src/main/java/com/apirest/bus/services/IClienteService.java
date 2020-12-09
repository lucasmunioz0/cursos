package com.apirest.bus.services;

import java.util.List;

import com.apirest.bus.domain.Cliente;

public interface IClienteService {

	List<Cliente> getAll();
	Cliente getById(Long id);
	
	Cliente save(Cliente cliente);
	
	void delete(Long id);
}

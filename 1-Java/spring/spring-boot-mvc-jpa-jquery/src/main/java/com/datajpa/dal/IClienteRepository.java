package com.datajpa.dal;



import java.util.List;

import com.datajpa.domain.Cliente;

public interface IClienteRepository {

	List<Cliente> findAll();
	
	void save(Cliente cliente);
	
	Cliente findOne(Long id);
	
	void delete(Long id);
}

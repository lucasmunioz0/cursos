package com.apirest.bus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.bus.domain.Cliente;
import com.apirest.dal.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente getById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}

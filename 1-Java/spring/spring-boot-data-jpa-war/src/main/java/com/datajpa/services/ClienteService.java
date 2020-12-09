package com.datajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datajpa.dal.IClienteDao;
import com.datajpa.dal.IClienteRepository;
import com.datajpa.domain.Cliente;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private IClienteRepository dao;
	@Autowired
	private IClienteDao daoCrud;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) daoCrud.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		daoCrud.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return daoCrud.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		daoCrud.deleteById(id);
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return daoCrud.findAll(pageable);
	}
}

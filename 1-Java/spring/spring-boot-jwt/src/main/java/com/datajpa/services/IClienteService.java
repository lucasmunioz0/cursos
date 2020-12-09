package com.datajpa.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datajpa.domain.Cliente;
import com.datajpa.domain.Factura;
import com.datajpa.domain.Producto;

public interface IClienteService {

	List<Cliente> findAll();
	
	Page<Cliente> findAll(Pageable pageable);

	void save(Cliente cliente);

	Cliente findOne(Long id);

	Cliente fetchOne(Long id);
	
	void delete(Long id);
	
	List<Producto> findByNombre(String nombre);
	
	void saveFactura(Factura factura);
	
	Producto findProductoById(Long id);
	
	Factura findFacturaById(Long id);
	
	void deleteFactura(Long id);
	
	Factura fetchFacturaById(Long id);
	
}

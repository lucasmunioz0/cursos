package com.datajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datajpa.dal.IClienteDao;
import com.datajpa.dal.IClienteRepository;
import com.datajpa.dal.IFacturaRepository;
import com.datajpa.dal.IProductoDao;
import com.datajpa.domain.Cliente;
import com.datajpa.domain.Factura;
import com.datajpa.domain.Producto;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private IClienteRepository dao;
	@Autowired
	private IClienteDao daoCrud;
	@Autowired
	private IProductoDao productoDao;
	@Autowired
	private IFacturaRepository facturaDao;

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
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return daoCrud.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String nombre) {
		return productoDao.findByNombreLikeIgnoreCase("%" + nombre + "%");
	}

	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteFactura(Long id) {
		facturaDao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Factura fetchFacturaById(Long id) {
		return facturaDao.fetchByIdWithClienteWithDetalleFacturaWithProducto(id);
	}

	@Override
	public Cliente fetchOne(Long id) {
		return daoCrud.fetchCliente(id);
	}
}

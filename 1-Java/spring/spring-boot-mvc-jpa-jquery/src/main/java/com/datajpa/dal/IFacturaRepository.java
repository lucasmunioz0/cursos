package com.datajpa.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.datajpa.domain.Factura;

public interface IFacturaRepository extends CrudRepository<Factura, Long>{

	@Query("select f from Factura f join fetch f.cliente c join fetch f.detalles d join fetch d.producto where f.id = ?1")
	Factura fetchByIdWithClienteWithDetalleFacturaWithProducto(Long id);
}

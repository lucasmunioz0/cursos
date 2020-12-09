package com.datajpa.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.datajpa.domain.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

	@Query("select p from Producto p where p.nombre like %?1%")
	List<Producto> findByNombre(String nombre);
	
	List<Producto> findByNombreLikeIgnoreCase(String nombre);
}

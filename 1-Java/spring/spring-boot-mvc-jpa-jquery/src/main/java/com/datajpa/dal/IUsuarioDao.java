package com.datajpa.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.datajpa.domain.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.authorities a where u.id=?1")
	Usuario fetch(Long id);
	
	Usuario findByUsername(String username);
}

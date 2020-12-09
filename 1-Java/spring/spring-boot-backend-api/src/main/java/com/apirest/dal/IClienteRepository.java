package com.apirest.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.bus.domain.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{

}

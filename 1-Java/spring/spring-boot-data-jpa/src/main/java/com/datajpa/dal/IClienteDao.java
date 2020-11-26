package com.datajpa.dal;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.datajpa.domain.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

}

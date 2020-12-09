package com.datajpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datajpa.domain.Cliente;
import com.datajpa.services.IClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping({"/", "/listar", ""})
	@Secured("ROLE_ADMIN")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
}

package com.micuper.rest.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.micuper.rest.domain.Cliente;

@Service
public class ClienteService {
	
	private List<Cliente> clientes;
	
	public ClienteService() {
		clientes = new ArrayList<>();
		clientes.add(new Cliente(1, "Lucas", "Muñoz"));
		clientes.add(new Cliente(2, "Otro", "Prueba"));
	}
	
	public List<Cliente> findAll(){
		return clientes;
	}

	public Cliente findById(Integer id) {
		Cliente cliente = null;
		for(Cliente c: clientes) {
			if(c.getId() == id) {
				cliente = c;
				break;
			}
		}
		return cliente;
	}

	public Cliente insert(Cliente cliente) {
		System.out.println("Cliente: " + cliente + " // clientes: " + clientes);
		clientes.add(cliente);
		System.out.println("Cliente AGREGADO " + "// clientes: " + clientes);
		return cliente;
	}
}

package com.datajpa.view;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.datajpa.domain.Cliente;

import lombok.Data;

@XmlRootElement(name="clientes")
public class ClienteList {
	@XmlElement(name = "cliente")
	private List<Cliente> clientes;
	
	public ClienteList() {
		clientes = new ArrayList<>();
	}

	public ClienteList(List<Cliente> clientes) {
		this();
		this.clientes = clientes;
	}
	
	public List<Cliente> getClientes(){
		return this.clientes;
	}
}

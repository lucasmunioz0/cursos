package com.micuper.di.models;

import java.io.Serializable;
import java.util.List;

public class Factura implements Serializable{
	
	private static final long serialVersionUID = 6047167918393163630L;
	
	private String descripcion;
	private Cliente cliente;
	private List<ItemFactura> items;

	public Factura() {

	}

	public Factura(String descripcion, Cliente cliente, List<ItemFactura> items) {
		this.descripcion = descripcion;
		this.cliente = cliente;
		this.items = items;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Factura [descripcion=" + descripcion + ", cliente=" + cliente + ", items=" + items + "]";
	}
	
	

}

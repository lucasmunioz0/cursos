package com.micuper.di.models;

public class ItemFactura {
	private Producto producto;
	private Integer cantidad;

	public ItemFactura() {

	}

	public ItemFactura(Producto producto, Integer cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer calcularTotal() {
		return producto.getPrecio() * cantidad;
	}

}

package com.datajpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "detalle_factura")
@Data
public class DetalleFactura implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_factura")
	private Long id;
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Producto producto;
	
	public DetalleFactura(Integer cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public DetalleFactura() {
	}
	
	public Double calcularImporte() {
		return cantidad.doubleValue() * producto.getPrecio();
	}
}

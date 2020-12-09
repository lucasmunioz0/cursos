package com.datajpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id;
	private String nombre;
	private Double precio;
	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public Producto() {
	}

	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
}

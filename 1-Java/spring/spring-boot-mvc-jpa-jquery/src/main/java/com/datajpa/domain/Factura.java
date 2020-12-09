package com.datajpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "facturas")
@Data
public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private Long id;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_factura")
	private List<DetalleFactura> detalles;
	@NotEmpty(message = "La descripción es requerida.")
	private String descripcion;
	private String observacion;
	@Temporal(TemporalType.DATE)
	@Column(name = "create_at")
	private Date createdAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonBackReference
	private Cliente cliente;
	
	 @PrePersist
	 public void prePersist() {
		 createdAt= new Date();
	 }
	
	public Factura() {
		detalles = new ArrayList<>();
	}
	
	public Factura(List<DetalleFactura> detalles, String descripcion, String observacion, Date fecha) {
		this();
		this.detalles = detalles;
		this.descripcion = descripcion;
		this.observacion = observacion;
		this.createdAt = fecha;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for (DetalleFactura detalle : detalles) {
			total += detalle.calcularImporte();
		}
		return total;
	}
	
	public void addDetalleFactura(DetalleFactura detalle) {
		detalles.add(detalle);
	}
	
	@XmlTransient
	public Cliente getCliente() {
		return this.cliente;
	}
}

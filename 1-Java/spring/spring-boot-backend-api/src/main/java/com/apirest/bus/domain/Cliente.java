package com.apirest.bus.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	@Column(nullable = false)
	@NotEmpty
	@Size(min = 4, max = 12)
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email
	@Column(nullable = false, unique = true)
	private String email;
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createdAt;
	

}

package com.udemy.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class Persona implements Serializable{    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;    
    @NotEmpty
    private String nombre;    
    @NotEmpty
    private String apellido;    
    @NotEmpty
    @Email
    private String email;    
    private String telefono;
}

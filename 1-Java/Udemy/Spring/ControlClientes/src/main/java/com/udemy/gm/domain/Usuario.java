package com.udemy.gm.domain;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Table(name="usuarios")
@Data
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_usuario")
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    
    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;
}

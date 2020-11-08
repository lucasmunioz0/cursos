package com.udemy.vacantes.models;

import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private String perfil;
    private String estatus = "activo";

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(String nombre, String email, String username, String password, String perfil) {
        this.nombre = nombre;
        this.email = email;
        this.username = username;
        this.password = password;
        this.perfil = perfil;
    }
}

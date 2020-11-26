package com.horario.error.exceptions;

public class UsuarioExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsuarioExeption(String message) {
		super("Usuario con ID:".concat(message).concat(" no existe en el sistema."));
	}

	
}

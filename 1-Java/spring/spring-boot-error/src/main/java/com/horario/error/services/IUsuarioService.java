package com.horario.error.services;

import java.util.List;
import java.util.Optional;

import com.horario.error.models.Usuario;

public interface IUsuarioService {

	List<Usuario> listar();
	
	Usuario obtenerPorId(Long id);
	
	Optional<Usuario> obtenerPorIdOpt(Long id);
}

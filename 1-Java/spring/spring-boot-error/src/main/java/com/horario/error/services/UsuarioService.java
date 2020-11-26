package com.horario.error.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.horario.error.models.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
	
	private List<Usuario> lista;
	
	public UsuarioService() {
		this.lista = new ArrayList();
		lista.add(new Usuario(1L, "Lucas", "Muñoz"));
		lista.add(new Usuario(2L, "Lucas 1", "Muñoz 1"));
		lista.add(new Usuario(3L, "Lucas 2", "Muñoz 2"));
		lista.add(new Usuario(4L, "Lucas 3", "Muñoz 3"));
	}

	@Override
	public List<Usuario> listar() {
		return lista;
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		Usuario aux = null;
		for (Usuario usuario : lista) {
			if(usuario.getId().equals(id)) {
				aux = usuario;
				break;
			}
		}
		return aux;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOpt(Long id) {
		Usuario aux = obtenerPorId(id);
		return Optional.ofNullable(aux);
	}

}

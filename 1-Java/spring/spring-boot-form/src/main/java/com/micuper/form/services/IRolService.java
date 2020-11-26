package com.micuper.form.services;

import java.util.List;

import com.micuper.form.domain.Rol;

public interface IRolService {

	List<Rol> listar();
	Rol obtenerPorId(Integer id);
}

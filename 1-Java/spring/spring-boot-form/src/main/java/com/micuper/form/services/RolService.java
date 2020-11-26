package com.micuper.form.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.micuper.form.domain.Rol;

@Service
public class RolService implements IRolService{
	
	private List<Rol> roles;
	
	public RolService() {
		this.roles = new ArrayList<>(3);
		this.roles.add(new Rol(1, "Administrador", "ROLE_ADMIN"));
		this.roles.add(new Rol(2, "Moderador", "ROLE_MODERADOR"));
		this.roles.add(new Rol(3, "User", "ROLE_USER"));
	}

	@Override
	public List<Rol> listar() {
		return roles;
	}

	@Override
	public Rol obtenerPorId(Integer id) {
		Rol rol = null;
		for (Rol r : roles) {
			if(r.getId() == id) {
				rol = r;
				break;
			}
		}
		return rol;
	}

}

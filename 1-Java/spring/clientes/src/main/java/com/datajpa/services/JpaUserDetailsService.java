package com.datajpa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datajpa.dal.IUsuarioDao;
import com.datajpa.domain.Rol;
import com.datajpa.domain.Usuario;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JpaUserDetailsService implements UserDetailsService{
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			log.error("Error login: no existe el usuario " + username);
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema");
		}
		
		if(!usuario.getEnable()) {
			log.error("Error login: " + username + " no esta habilitado");
			throw new DisabledException("Username: " + username + " esta inhabilitado.");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>(usuario.getAuthorities().size());
		
		for (Rol rol : usuario.getAuthorities()) {
			log.info("Role: " + rol.getAuthority());
			authorities.add(new SimpleGrantedAuthority(rol.getAuthority()));
		}
		
		if(authorities.isEmpty()) {
			log.error("Error login: no tiene roles asignados " + username);
			throw new DisabledException("Username: " + username + " no tiene roles en el sistema");
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(), true, true, true, authorities);
	}
}

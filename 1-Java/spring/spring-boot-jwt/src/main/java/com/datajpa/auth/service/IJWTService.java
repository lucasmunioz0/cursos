package com.datajpa.auth.service;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.IOException;

public interface IJWTService {
	
	String create(Authentication auth) throws JsonProcessingException;
	boolean validate(String token);
	Claims getClaims(String token);
	String getUsername(String token);
	Collection<? extends GrantedAuthority> getRoles(String token) throws IOException, JsonMappingException, JsonProcessingException;
	String resolve(String token);
}

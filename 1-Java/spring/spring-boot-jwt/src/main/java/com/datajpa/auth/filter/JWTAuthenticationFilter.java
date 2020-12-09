package com.datajpa.auth.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.datajpa.auth.service.IJWTService;
import com.datajpa.auth.service.JWTService;
import com.datajpa.domain.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	private IJWTService jwtService;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, IJWTService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
	}	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		
		if(username != null && password != null) {
			logger.info("Usuario: " + username + " - Password: " + password);
		}else {
			Usuario user = null;
			try {
				 user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
				 username = user.getUsername();
				 password = user.getPassword();
				 logger.info("Usuario: " + username + " - Password: " + password);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		username = username.trim();
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		
		return authenticationManager.authenticate(authToken);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {		
		String token = jwtService.create(authResult);
		response.addHeader(JWTService.HEADER_STRING, JWTService.TOKEN_PREFIX + token);
		
		Map<String, Object> body = new HashMap<>();
		body.put("token", token);
		body.put("user", (User) authResult.getPrincipal());
		body.put("mensaje", String.format("Hola %s, has iniciado sesión con éxito", authResult.getName()));
		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(200);
		response.setContentType("application/json;charset=utf-8");
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		Map<String, Object> body = new HashMap<>();
		body.put("mensaje", failed.getMessage());
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setStatus(401);
		response.setContentType("application/json;charset=utf-8");
	}
}

package com.datajpa.auth.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.datajpa.auth.filter.SimpleGrantedAuthorityMixin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JWTService implements IJWTService{
	
	public static final String SECRET = Base64Utils.encodeToString("Alguna.Clave.Secreta.12345676123".getBytes());
	private SecretKey secretKey = new SecretKeySpec(SECRET.getBytes(), SignatureAlgorithm.HS512.getJcaName());
	public static final long EXPIRATION_DATE = 3600000L * 4L;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

	@Override
	public String create(Authentication auth) throws JsonProcessingException {
		log.info("SECRET: " + SECRET);
		log.info("KEY GENERADA: " + secretKey.getEncoded());
		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
		Claims claims = Jwts.claims();
		claims.put("authorities", new ObjectMapper().writeValueAsString(roles));
		
		String token = Jwts.builder()
				.setClaims(claims)
				.setSubject(auth.getName())
				.signWith(secretKey)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
				.compact();
		
		log.info("TOKEN GENERADO: " + secretKey.getEncoded());
		return token;
	}

	@Override
	public boolean validate(String token) {
		try {
			getClaims(token);
			return true;
		}catch(JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public Claims getClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(SECRET.getBytes())
				.build()
				.parseClaimsJws(resolve(token))
				.getBody();
	}

	@Override
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException, JsonMappingException, JsonProcessingException {
		String roles = getClaims(token).get("authorities").toString();
		Collection<? extends GrantedAuthority> authorities = Arrays.asList(new ObjectMapper()
				.addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityMixin.class)
				.readValue(roles, SimpleGrantedAuthority[].class));
		
		return authorities;
	}

	@Override
	public String resolve(String token) {
		return token != null && token.startsWith(TOKEN_PREFIX)? token.replace(TOKEN_PREFIX, "") : null;
	}

}

package com.datajpa.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class LoginFailedHandler extends SimpleUrlAuthenticationFailureHandler{
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		if(exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
			setDefaultFailureUrl("/login?error=Credenciales incorrectas");
		}else if(exception.getClass().isAssignableFrom(DisabledException.class)){
			setDefaultFailureUrl("/login?error=Usuario deshabilitado");
		}else if(exception.getClass().isAssignableFrom(UsernameNotFoundException.class)) {
			setDefaultFailureUrl("/login?error=Usuario no registrado en el sistema");
		}
		
		SessionFlashMapManager flash = new SessionFlashMapManager();
		FlashMap flashMap = new FlashMap();
		flashMap.put("error", exception.getMessage());
		flash.saveOutputFlashMap(flashMap, request, response);
//		log.info("Hola: " + exception.getMessage());
		super.onAuthenticationFailure(request, response, exception);
	}

}

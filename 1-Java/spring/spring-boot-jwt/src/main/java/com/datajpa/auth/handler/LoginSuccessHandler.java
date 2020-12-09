package com.datajpa.auth.handler;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private LocaleResolver localeResolver;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		SessionFlashMapManager flash = new SessionFlashMapManager();
		FlashMap flashMap = new FlashMap();
		flashMap.put("success", "Inicio sesión con éxito");
		flash.saveOutputFlashMap(flashMap, request, response);
		Locale locale = localeResolver.resolveLocale(request);
		if(authentication != null) {
			log.info("El usuario '" + authentication.getName() +"' ha hiciado sesión con éxito");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}

package com.micuper.form.interceptores;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("carga")
public class CargaInterceptor implements HandlerInterceptor{
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(CargaInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			return true;
		}
		
		
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("time", tiempoInicio);
		Integer demora = new Random().nextInt(100);
		String metodo = request.getMethod();
		String path = request.getRequestURI();
		System.out.println("INTERCEPTANDO ANTES: " + path + " method: " + metodo + " handler: " + handler);
		log.info("ENTRANDO: " + path + " method: " + metodo + " handler: " + handler);
		Thread.sleep(demora);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")) {
			return;
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoInicial = Long.parseLong(request.getAttribute("time").toString());
		long tiempo = (tiempoFinal - tiempoInicial);
		String metodo = request.getMethod();
		String path = request.getRequestURI();
		System.out.println("INTERCEPTANDO DESPUES: " + path + " method: " + metodo + " handler: " + handler);
		
		if(handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("tiempo", tiempo);
			System.out.println("MÉTODO: " + ((HandlerMethod) handler).getMethod().getName());
		}
		
		log.info("SALIENDO: " + path + " method: " + metodo + " / Tiempo total:" + tiempo  + "ms" + " handler: " + handler);
	}
}

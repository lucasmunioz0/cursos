package com.horario.error.web;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.horario.error.exceptions.UsuarioExeption;

@ControllerAdvice
public class ErrorController{

	@ExceptionHandler({ArithmeticException.class})
	public String aritmeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error de aritmetica");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}
	
	@ExceptionHandler({NumberFormatException.class})
	public String numberFormatException(NumberFormatException ex, Model model) {
		model.addAttribute("error", "Error de conversión");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}
	
	@ExceptionHandler({UsuarioExeption.class})
	public String usuarioExeption(UsuarioExeption ex, Model model) {
		model.addAttribute("error", "Usuario no encontrado");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/aritmetica";
	}
	
}

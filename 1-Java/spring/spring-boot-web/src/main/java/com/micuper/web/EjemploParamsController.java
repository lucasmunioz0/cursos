package com.micuper.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index(@RequestParam(required = false, defaultValue = "algun valor...") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/index";
	}

	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "algun valor...") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(String saludo, Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "', y el número: '" + numero + "'");
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "', y el número: '" + numero + "'");
		return "params/ver";
	}
}

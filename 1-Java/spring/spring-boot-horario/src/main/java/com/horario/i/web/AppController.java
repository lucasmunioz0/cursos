package com.horario.i.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;

	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenido a la vista");
		return "index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		StringBuilder mensaje = new StringBuilder("El sistema esta fuera de horario de atención.");
		mensaje.append("Atendemos desde las ");
		mensaje.append(apertura).append("hs hasta las ").append(cierre).append("hs.");
		model.addAttribute("titulo", "El sistema se encuentra cerrado");
		model.addAttribute("horario", mensaje.toString());
		return "cerrado";
	}
}

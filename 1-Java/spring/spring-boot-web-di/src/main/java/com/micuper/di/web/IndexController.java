package com.micuper.di.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.micuper.di.services.IServicio;

@Controller
public class IndexController {
	
	@Autowired
	//@Qualifier("miServicioSimple")
	private IServicio servicio;	
	

	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Inyección de dependencias");
		model.addAttribute("resultado", servicio.operacion());
		return "index";
	}
}

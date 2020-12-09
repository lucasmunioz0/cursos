package com.datajpa.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Principal user, Model model, RedirectAttributes flash) {
		if(user != null) {
			flash.addFlashAttribute("info", "Ya ha iniciado sesión.");
			return "redirect:/clientes";
		}
		
		if(logout != null) {
			model.addAttribute("success", "Se ha cerrado sesión con éxito");
		}
		
		if(error != null) {
			model.addAttribute("error", "Error en el login: Usuario o contraseña incorrecta, por favor vuelva a intentar: " + error);
		}
		return "login";
	}

}

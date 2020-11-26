package com.horario.error.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.horario.error.exceptions.UsuarioExeption;
import com.horario.error.models.Usuario;
import com.horario.error.services.IUsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping({"/", "", "index"})
	@SuppressWarnings("unused")
	public String index() {
//		Integer valor = 100/0;
		Integer valor = Integer.parseInt("12s");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(Model model, @PathVariable Long id) {
//		Usuario usuario = service.obtenerPorId(id);
//		if (usuario == null) {
//			throw new UsuarioExeption(id.toString());
//		}
		
		Usuario usuario = service.obtenerPorIdOpt(id).orElseThrow(() -> new UsuarioExeption(id.toString()));
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle de usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}

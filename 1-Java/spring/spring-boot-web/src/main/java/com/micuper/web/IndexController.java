package com.micuper.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.micuper.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping({"/index", "", "/", "home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Lucas");
		usuario.setApellido("Muñoz");
		usuario.setEmail("lucasmunioz0@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil);
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String perfiles(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("lucas", "muñoz", "lucasmunioz0@gmail.com"),
				new Usuario("lucas2", "muñoz2", "lucasmunioz2@gmail.com"),
				new Usuario("lucas3", "muñoz3", "lucasmunioz3@gmail.com"),
				new Usuario("lucas4", "muñoz4", "lucasmunioz4@gmail.com"));
		
		return usuarios;
	}
}

package com.micuper.form.web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.micuper.form.domain.Pais;
import com.micuper.form.domain.Rol;
import com.micuper.form.domain.Usuario;
import com.micuper.form.editors.NombreMayusculaEditor;
import com.micuper.form.editors.PaisPropertyEditor;
import com.micuper.form.editors.RolesEditor;
import com.micuper.form.services.IRolService;
import com.micuper.form.services.IServicioPais;
import com.micuper.form.validation.UsuarioValidador;

@Controller
@RequestMapping("/form")
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	@Autowired
	private IServicioPais paisService;
	@Autowired
	private PaisPropertyEditor paisEditor;
	@Autowired
	private RolesEditor rolEditor;
	@Autowired
	private IRolService rolService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
		binder.registerCustomEditor(Rol.class, "roles", rolEditor);
	}

	@GetMapping({"/", ""})
	public String form(Model model, Usuario usuario) {
		usuario.setNombre("John");
		usuario.setValorSecreto("Valor secreto");
		usuario.setPais(new Pais(2, "MX", "Mexico"));
		usuario.setRoles(Arrays.asList(new Rol(3, "User", "ROLE_USER")));
		usuario.setApellido("Doe");
		usuario.setId("23.123.145-B");
		usuario.setHabilitar(true);
		return "form";
	}
	
	@PostMapping("/v1")
	public String procesarFormUsandoAnotacion(Model model, @RequestParam String username, 
			@RequestParam String password, @RequestParam String email) {
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		model.addAttribute("titulo", "Procesando form con anotaciones RequestParam.");
		return "resultado";
	}
	
	@PostMapping("/v2")
	public String procesarFormSinAnotaciones(Model model, String username, 
			String password, String email) {	
		Usuario usuario = new Usuario(username, password, email);
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Procesando form sin anotaciones RequestParam.");
		return "resultado";
	}
	
	@PostMapping("/v3")
	public String procesarFormConModelo(@Valid Usuario usuario, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "form";
		}
		
		return "redirect:/form/resultado";
	}
	
	@GetMapping("/resultado")
	public String resultado(Model model, SessionStatus status, @SessionAttribute(name = "usuario", required = false) Usuario usuario) {
		if(usuario == null) {
			return "redirect:/form";
		}
		
		model.addAttribute("titulo", "Procesando form con bindeo de modelo.");
		status.setComplete();
		return "resultado";
	}
	
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("Argentina", "Chile", "México", "España");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap(){
		Map<String, String> map = new HashMap<>();
		map.put("AR", "Argentina");
		map.put("CL", "Chile");
		map.put("ES", "España");
		map.put("MX", "Mexico");
		
		return map;
	}
	
	@ModelAttribute("paisesEntity")
	public List<Pais> paisesEntity(){
		return paisService.getPaises();
	}
	
	@ModelAttribute("rolesString")
	public List<String> rolesString(){
		return Arrays.asList("ROLE_ADMIN", "ROLE_SECRETARIO", "ROL_USUARIO");
	}
	
	@ModelAttribute("rolesStringMap")
	public Map<String, String> rolesMap(){
		Map<String, String> map = new HashMap<>();
		map.put("ROLE_ADMIN", "Administrador");
		map.put("ROLE_USUARIO", "Usuario");
		map.put("ROLE_SECRETARIO", "Secretario");
		return map;
	}
	
	@ModelAttribute("roles")
	public List<Rol> roles(){
		return rolService.listar();
	}
	
	@ModelAttribute("generos")
	public List<String> genero(){
		return Arrays.asList("Hombre", "Mujer");
	}
	
}

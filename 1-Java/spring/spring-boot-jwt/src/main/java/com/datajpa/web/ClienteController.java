package com.datajpa.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datajpa.domain.Cliente;
import com.datajpa.services.IClienteService;
import com.datajpa.services.UploadFileServices;
import com.datajpa.util.paginator.PageRender;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("cliente")
@Slf4j
public class ClienteController {
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private UploadFileServices fileService;
	@Autowired
	private MessageSource messageSource;

	@GetMapping({"/", "", "/clientes"})
	public String listar(Model model, @RequestParam(name = "page", defaultValue = "0") int page, 
			Authentication authentication, 
			HttpServletRequest request, Locale locale) {
		if(authentication != null) {
			log.info("El usuario authenticado es: ".concat(authentication.getName()).concat(" passs: ").concat(authentication.getDetails().toString()));
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			log.info("El usuario authenticado es: ".concat(auth.getName()).concat(" passs: ").concat(auth.getDetails().toString()));
		}
		
		if(hasRole("ROLE_ADMIN")) {
			log.info("El usuario es administrador");
		}
		
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "ROLE_");
		
		if(securityContext.isUserInRole("ADMIN")) {
			log.info("El usuario es administrador de otra forma");
		}
		
		if(request.isUserInRole("ROLE_ADMIN")) {
			log.info("El usuario es administrador utilizando el request");
		}
		
		
		Pageable pageRequest = PageRequest.of(page, 3);

		Page<Cliente> clientes = clienteService.findAll(pageRequest);

		PageRender<Cliente> pageRender = new PageRender<>("/clientes", clientes);

		model.addAttribute("titulo", messageSource.getMessage("text.cliente.listar.titulo", null, locale));
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		return "cliente/listar";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/clientes/{id}")
	public String ver(Model model, @PathVariable("id") Long id, RedirectAttributes flash) {
		Cliente cliente = clienteService.fetchOne(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe");
			return "redirect:/clientes/listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Detalle Cliente " + cliente.getNombre());
		return "cliente/ver";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/clientes/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Crear cliente");

		return "cliente/form";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/clientes/form/{id}")
	public String editar(@PathVariable Long id, Model model, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(id);

		if (id <= 0) {
			flash.addFlashAttribute("error", "El Id del Cliente no puede ser 0 o negativo.");
			return "redirect:/clientes/listar";
		} else if (cliente == null) {
			flash.addFlashAttribute("info", "El Cliente no existe en la base de datos.");
			return "redirect:/clientes/listar";
		}

		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar cliente");
		return "cliente/form";
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping("/clientes/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {
		Resource recurso = null;
		try {
			recurso = fileService.load(filename);
		} catch (MalformedURLException e) {

		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping({"/clientes/", "/clientes"})
	public String procesar(@Valid Cliente cliente, BindingResult errors, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		
		System.out.println("HOLAAAA");
		if (errors.hasErrors()) {
			model.addAttribute("titulo", "Crear cliente");
			return "cliente/form";
		}

		if (!foto.isEmpty()) {

			if (cliente.getId() != null && cliente.getId() > 0 && cliente.getFoto() != null
					&& cliente.getFoto().length() > 0) {
				fileService.delete(cliente.getFoto());
			}

			String uniqueFileName = null;
			try {
				uniqueFileName = fileService.copy(foto);
			} catch (IOException e) {
				flash.addFlashAttribute("error", "Problema al generar nombre para el archivo: " + uniqueFileName);
			}

			flash.addFlashAttribute("info", "Se ha subido correctamente el archivo: " + uniqueFileName);
			cliente.setFoto(uniqueFileName);
		}
		String mensajeFlash = (cliente.getId() != null ? "Cliente editado con éxito" : "Cliente creado con éxito");

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/clientes";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/clientes/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if (id > 0) {
			Cliente cliente = clienteService.findOne(id);
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con éxito");

			if (fileService.delete(cliente.getFoto())) {
				flash.addFlashAttribute("info", "Foto eliminada con éxito");
			}
		}

		return "redirect:/clientes";
	}
	
	@GetMapping("/listar-rest")
	@ResponseBody
	public List<Cliente> listarRest(){
		return clienteService.findAll();
	}
	
	private boolean hasRole(String role) {
		SecurityContext context = SecurityContextHolder.getContext();
		if(context == null) {
			return false;
		}
		
		Authentication auth = context.getAuthentication();
		
		if(auth == null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		return authorities.contains(new SimpleGrantedAuthority(role));
	}
}

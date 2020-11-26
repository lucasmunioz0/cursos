package com.datajpa.web;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datajpa.domain.Cliente;
import com.datajpa.services.IClienteService;
import com.datajpa.services.UploadFileServices;
import com.datajpa.util.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private UploadFileServices fileService;

	@GetMapping("/listar")
	public String listar(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		Pageable pageRequest = PageRequest.of(page, 3);

		Page<Cliente> clientes = clienteService.findAll(pageRequest);

		PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);

		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		return "listar";
	}

	@GetMapping("/ver/{id}")
	public String ver(Model model, @PathVariable("id") Long id, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe");
			return "redirect:/listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Detalle Cliente " + cliente.getNombre());
		return "ver";
	}

	@GetMapping("/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Crear cliente");

		return "form";
	}

	@GetMapping("/form/{id}")
	public String editar(@PathVariable Long id, Model model, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(id);

		if (id <= 0) {
			flash.addFlashAttribute("error", "El Id del Cliente no puede ser 0 o negativo.");
			return "redirect:/listar";
		} else if (cliente == null) {
			flash.addFlashAttribute("info", "El Cliente no existe en la base de datos.");
			return "redirect:/listar";
		}

		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar cliente");
		return "form";
	}

	@GetMapping("/uploads/{filename:.+}")
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

	@PostMapping("/form")
	public String procesar(@Valid Cliente cliente, BindingResult errors, Model model,
			@RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		if (errors.hasErrors()) {
			model.addAttribute("titulo", "Crear cliente");
			return "form";
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
		return "redirect:/listar";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		if (id > 0) {
			Cliente cliente = clienteService.findOne(id);
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado con éxito");

			if (fileService.delete(cliente.getFoto())) {
				flash.addFlashAttribute("info", "Foto eliminada con éxito");
			}
		}

		return "redirect:/listar";
	}
}

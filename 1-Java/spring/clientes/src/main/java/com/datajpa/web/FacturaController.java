package com.datajpa.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datajpa.domain.Cliente;
import com.datajpa.domain.DetalleFactura;
import com.datajpa.domain.Factura;
import com.datajpa.domain.Producto;
import com.datajpa.services.IClienteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/facturas")
@SessionAttributes("factura")
@Secured("ROLE_ADMIN")
@Slf4j
public class FacturaController {
	@Autowired
	private IClienteService clienteService;

	@PostMapping({"/", ""})
	public String guardar(@Valid Factura factura, BindingResult errors, @RequestParam(name="item_id[]", required = false) Long[] itemId,
			@RequestParam(name="cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash, SessionStatus status, Model model) {
		
		if(errors.hasErrors()) {
			model.addAttribute("tituto", "Crear factura");
			return "factura/form";
		}
		
		if(itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", "Crear factura");
			model.addAttribute("error", "Error: La factura NO puede no tener productos seleccionados.");
			return "factura/form";
		}
		
		for	(int i=0; i < itemId.length; i++) {
			Producto producto = clienteService.findProductoById(itemId[i]);
			DetalleFactura detalle = new DetalleFactura(cantidad[i], producto);
			factura.addDetalleFactura(detalle);
			log.info("ID: " + itemId[i] + " - Cantidad: " + cantidad[i]);
		}
		
		clienteService.saveFactura(factura);
		status.setComplete();
		flash.addFlashAttribute("success", "Factura creada con éxito!");
		return "redirect:/clientes/" + factura.getCliente().getId();
	}
	
	@GetMapping("/form/{idCliente}")
	public String form(@PathVariable Long idCliente, Model model, RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(idCliente);

		if(cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe");
			return "redirect:/listar";
		}
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Crear nueva factura");
		return "factura/form";
	}
	
	@GetMapping("/{id}")
	public String ver(@PathVariable Long id, Model model, RedirectAttributes flash) {
		
		Factura factura = clienteService.fetchFacturaById(id);
		
		if(factura == null) {
			flash.addFlashAttribute("error", "La factura no existe en la base de datos");
			return "redirect:/clientes";
		}
		
		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Detalle de factura: " + factura.getDescripcion());
		return "factura/ver";
	}
	
	@GetMapping(value = "/cargar-productos/{nombre}", produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Producto> buscar(@PathVariable String nombre){
		return clienteService.findByNombre(nombre);
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
		Factura factura = clienteService.findFacturaById(id);
		
		if(factura != null) {
			clienteService.deleteFactura(id);
			flash.addFlashAttribute("success", "Factura eliminada con éxito");
			return "redirect:/clientes/" + factura.getCliente().getId();
		}
		
		flash.addAttribute("error", "La factura no existe en la Base de Datos");
		return "redirect:/clientes";
	}
}

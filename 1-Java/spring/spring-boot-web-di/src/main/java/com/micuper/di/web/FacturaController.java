package com.micuper.di.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.micuper.di.models.Factura;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
	
	@Autowired
	private List<Factura> facturas;

	@GetMapping("/ver")
	public String verFactura(Integer index, Model model) {
		Factura factura = facturas.get(index);
		model.addAttribute("items", factura.getItems());
		model.addAttribute("titulo", "Detalle de factura");		
		return "factura/ver";
	}
	
	@GetMapping({"", "/"})
	public String listarFacturas(Model model) {
		
		System.out.println(facturas.size());
		facturas.forEach(System.out::println);
		
		model.addAttribute("facturas", facturas);
		model.addAttribute("titulo", "Listado de facturas");
		return "index";
	}
	
}

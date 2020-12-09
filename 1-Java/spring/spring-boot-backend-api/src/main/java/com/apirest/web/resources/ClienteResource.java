package com.apirest.web.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.bus.domain.Cliente;
import com.apirest.bus.services.IClienteService;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ClienteResource {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("")
	public List<Cliente> index() {
		return clienteService.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable("id") Long id) {
		Cliente cliente = null;
		try {
			cliente = clienteService.getById(id);
		} catch (DataAccessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() + ": " + e.getMostSpecificCause());
		}

		if (cliente == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no registrado en la base de datos");
		}

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String destroy(@PathVariable("id") Long id) {
		clienteService.delete(id);
		return "Cliente eliminado con éxito";
	}

	@PostMapping("")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		Cliente clienteNew = null;
		Map<String, Object> response = new HashMap<>();
		
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo: '" + error.getField() + "' " + error.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		try {
			clienteNew = clienteService.save(cliente);
		} catch (DataAccessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() + ": " + e.getMostSpecificCause());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteNew);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente, BindingResult result) throws Exception {
		Cliente aux = clienteService.getById(id);
		if (aux == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El cliente no existe, por lo tanto no se puede actualizar");
		}
		Map<String, Object> response = new HashMap<>();
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(error -> "El campo: '" + error.getField() + "' " + error.getDefaultMessage()).collect(Collectors.toList());
			response.put("errors", errors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		try {
			aux = clienteService.save(cliente);
		}catch (DataAccessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage() + ": " + e.getMostSpecificCause());
		}
		
		return ResponseEntity.ok(aux);
	}
}

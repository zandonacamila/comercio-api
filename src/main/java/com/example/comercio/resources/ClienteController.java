package com.example.comercio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comercio.models.Cliente;
import com.example.comercio.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/{nome}")
	public ResponseEntity<Cliente> buscaPorNome(@PathVariable String nome) {
		Cliente cliente = service.buscaPorNome(nome);
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> buscaTodos() {
		List<Cliente> clientes = service.buscaTodos();
		return ResponseEntity.ok().body(clientes);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insere(@RequestBody Cliente cliente) {
		cliente = service.salva(cliente);
		return ResponseEntity.ok().body(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> remove(Cliente cliente) {
		service.remove(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> altera(@PathVariable Integer id, @RequestBody Cliente cliente) {
		service.atualiza(id, cliente);
		return ResponseEntity.ok().body(cliente);
		
	}
}

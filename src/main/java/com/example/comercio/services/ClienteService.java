package com.example.comercio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.comercio.models.Cliente;
import com.example.comercio.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente buscaPorId(Integer id) {
		Optional<Cliente> cliente = repository.findById(id); 
		return cliente.orElseThrow(() -> new EmptyResultDataAccessException(id));
	}

	public Cliente buscaPorNome(String nome) {

		return repository.findByNome(nome);
	}
	
	public List<Cliente> buscaTodos() {
		
		return repository.findAll();
	}
	
	public void remove(Cliente cliente) {
		repository.delete(cliente);
	}
	
	public void deleta(Integer id) {
		
		try {
			repository.deleteById(id);		
			
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
	
	public Cliente salva(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente atualiza(Integer id, Cliente obj) {
				
		try {
			Cliente cliente = repository.getOne(id);
			updateData(cliente, obj);
			return repository.save(cliente);			
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException(e.getMessage(), 5);
		}
	}
	
	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setSenha(obj.getSenha());
		entity.setDtNascimento(obj.getDtNascimento());
	}
}

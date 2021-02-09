package com.example.comercio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.comercio.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public Cliente findByNome(String nome);
}

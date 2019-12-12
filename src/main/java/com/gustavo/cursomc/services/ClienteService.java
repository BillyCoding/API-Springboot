package com.gustavo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.cursomc.domain.Cliente;
import com.gustavo.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	public Cliente Buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
}

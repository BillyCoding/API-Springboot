package com.gustavo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	public Categoria Buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	
	public Categoria insert (Categoria obj) 
	{
		obj.setIdCat(null);
		return repo.save(obj);
	}
}


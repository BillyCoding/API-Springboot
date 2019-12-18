package com.gustavo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.repositories.CategoriaRepository;
import com.gustavo.cursomc.services.exceptions.DataIntegrityException;
import com.gustavo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	public Categoria Buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	
	public Categoria insert (Categoria obj) 
	{
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update (Categoria obj)
	{
		Buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete (Integer id) 
	{
		Buscar(id);
		try 
		{
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) 
		{
			throw new DataIntegrityException("Não é possível deletar a categoria referente ao id " + id);
		}
		
	}
}


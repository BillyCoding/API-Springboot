package com.gustavo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.dto.CategoriaDTO;
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
	
	public List<Categoria> findAll()
	{
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer lines,String orderBy , String direction)
	{
		PageRequest pgReq = PageRequest.of(page, lines, Direction.valueOf(direction), orderBy);
		return repo.findAll(pgReq);
	}
	
	public Categoria fromDTO(CategoriaDTO objDTO)
	{
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
}


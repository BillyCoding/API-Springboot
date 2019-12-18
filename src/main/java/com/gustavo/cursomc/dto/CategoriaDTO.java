package com.gustavo.cursomc.dto;

import java.io.Serializable;

import com.gustavo.cursomc.domain.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CategoriaDTO() {}

	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public CategoriaDTO(Categoria obj) 
	{
		id = obj.getId();
		nome = obj.getNome();
	}
}

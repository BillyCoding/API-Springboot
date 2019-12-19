package com.gustavo.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.gustavo.cursomc.domain.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=30, message = "O tamanho deve ser entre 5 e 30 caracteres")
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

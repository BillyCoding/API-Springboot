package com.gustavo.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Entity
public @Data class Cep implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade; 
	
	
	public Cep(String cep, String logradouro, String bairro, String cidade) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
	}


	private List<Endereco> endereco = new ArrayList<>();
}

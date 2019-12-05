package com.gustavo.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Cep cep;
	private String numero;
	private String complemento;
	private Cliente cliente;
	
	public Endereco(Integer id, Cep cep, String numero, String complemento, Cliente cliente) {
		super();
		this.id = id;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.cliente = cliente;
	}
	
	
	
	
	
	
}

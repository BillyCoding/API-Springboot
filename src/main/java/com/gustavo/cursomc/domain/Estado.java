package com.gustavo.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
public @Data class Estado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonBackReference
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidade = new ArrayList<>();

	public Estado() {}
	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
}

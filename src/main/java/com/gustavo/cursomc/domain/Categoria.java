package com.gustavo.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public @Data class Categoria implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		
		@JsonIgnore
		@ManyToMany(mappedBy="categorias")
		private List<Produto> produtos = new ArrayList<>(); 

		
		public Categoria() {}
		
		public Categoria(Integer id, String nome) {
			super();
			this.id = id;
			this.nome = nome;
		}

		
		
		
				
}

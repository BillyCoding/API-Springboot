package com.gustavo.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gustavo.cursomc.domain.enuns.TipoCliente;

import lombok.Data;

@Entity
public @Data class Cliente  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String CnpfCpf;
	private Integer tipo;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> endereco = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="TelefoneCliente")
	private Set<String> telefones = new HashSet<>();

	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public Cliente() {}

	public Cliente(Integer id, String nome, String email, String cnpfCpf, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		CnpfCpf = cnpfCpf;
		this.tipo = tipo.getCod();
	}
	
	
}

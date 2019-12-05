package com.gustavo.cursomc.domain.enuns;

import java.util.Optional;

import com.gustavo.cursomc.domain.Categoria;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum TipoCliente {
		
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) 
	{
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("O id [" + cod + "] não é válido");
	}
}

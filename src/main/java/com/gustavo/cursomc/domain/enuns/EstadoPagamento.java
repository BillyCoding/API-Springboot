package com.gustavo.cursomc.domain.enuns;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum EstadoPagamento {

	PENDENTE(1, "Pedido pendente"),
	QUITADO(2, "Pedido quitado"),
	CANCELADO(3, "Pedido cancelado");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) 
	{
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("O id [" + cod + "] não é válido");
	}
}

package com.gustavo.cursomc.domain;

import javax.persistence.Entity;

import com.gustavo.cursomc.domain.enuns.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;

	private Integer parcelas;

	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer parcelas) {
		super(id, estado, pedido);
		this.parcelas = parcelas;
	}
	
	
	
	
	
}

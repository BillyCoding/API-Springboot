package com.gustavo.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gustavo.cursomc.domain.enuns.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date DataVencimento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date DataPagamento;
	
	public PagamentoComBoleto () {}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);

		DataVencimento = dataVencimento;
		DataPagamento = dataPagamento;
	}
	
	
	
	
}

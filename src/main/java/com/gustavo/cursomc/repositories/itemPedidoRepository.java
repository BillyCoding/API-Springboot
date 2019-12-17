package com.gustavo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.cursomc.domain.ItemPedido;

@Repository
public interface itemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
	
	

}

package com.gustavo.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.cursomc.domain.Pedido;
import com.gustavo.cursomc.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		
		Pedido obj = service.Buscar(id);
		return ResponseEntity.ok(obj);
		
	}

}

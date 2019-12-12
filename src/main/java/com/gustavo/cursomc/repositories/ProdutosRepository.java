package com.gustavo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.cursomc.domain.Produto;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer>{

}

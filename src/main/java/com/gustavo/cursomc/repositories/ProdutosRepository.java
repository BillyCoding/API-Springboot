package com.gustavo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.cursomc.domain.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer>{

}

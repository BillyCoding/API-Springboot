package com.gustavo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.cursomc.domain.Cep;

@Repository
public interface CepRepository extends JpaRepository<Cep, Integer>{
	
	

}

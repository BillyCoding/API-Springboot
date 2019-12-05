package com.gustavo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.domain.Cep;
import com.gustavo.cursomc.domain.Cidade;
import com.gustavo.cursomc.domain.Cliente;
import com.gustavo.cursomc.domain.Endereco;
import com.gustavo.cursomc.domain.Estado;
import com.gustavo.cursomc.domain.Produtos;
import com.gustavo.cursomc.domain.enuns.TipoCliente;
import com.gustavo.cursomc.repositories.CategoriaRepository;
import com.gustavo.cursomc.repositories.CepRepository;
import com.gustavo.cursomc.repositories.CidadeRepository;
import com.gustavo.cursomc.repositories.ClienteRepository;
import com.gustavo.cursomc.repositories.EnderecoRepository;
import com.gustavo.cursomc.repositories.EstadoRepository;
import com.gustavo.cursomc.repositories.ProdutosRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired	
	private CategoriaRepository repo;
	@Autowired
	private ProdutosRepository prod;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	
	//Cliente
	
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private EnderecoRepository endeRepo;
	@Autowired
	private CepRepository cepRepo;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Notebook");
		Categoria cat2 = new Categoria(null, "Smartphone");
		Produtos pro1 = new Produtos(null, "IdeaPad 320", 1700.00);
		Produtos pro2 = new Produtos(null, "Moto G6 Indigo", 1250.00);
		Estado esta1 = new Estado(null, "SãoPaulo");
		Cidade cida1 = new Cidade(null, "Osasco", esta1);
		Cidade cida2 = new Cidade(null, "Barueri", esta1);
		Cidade cida3 = new Cidade(null, "Jandira", esta1);
		Cidade cida4 = new Cidade(null, "Carapicuíba", esta1);
		
		cat1.getProdutos().addAll(Arrays.asList(pro1));
		cat2.getProdutos().addAll(Arrays.asList(pro2));
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat2));
		
		esta1.getCidade().addAll(Arrays.asList(cida1));
		
		estadoRepo.saveAll(Arrays.asList(esta1));
		cidadeRepo.saveAll(Arrays.asList(cida1, cida2, cida3, cida4));
		
		repo.saveAll(Arrays.asList(cat1, cat2));
		prod.saveAll(Arrays.asList(pro1, pro2));
		
		// Cliente
		
		/*Cep cep1 = new Cep("06240060", "SP", "Jardim Elvira", "Osasco");
		Cep cep2 = new Cep("06243060", "SP", "Bel Jardim", "Osasco");
		Cliente cli1 = new Cliente(null, "Gustavo Ferreira", "gustavo.rocha.191066@gmail.com", "49891418812", TipoCliente.toEnum(1));
		Endereco ende1 = new Endereco(null, cep1, "302","Casa 2", cli1);
		Endereco ende2 = new Endereco(null, cep2, "1670","Casa 2", cli1);
		
		cep1.getEndereco().addAll(Arrays.asList(ende1));
		cep2.getEndereco().addAll(Arrays.asList(ende2));
		cli1.getEndereco().addAll(Arrays.asList(ende1, ende2));
		
		cepRepo.saveAll(Arrays.asList(cep1, cep2));
		clienteRepo.saveAll(Arrays.asList(cli1));
		endeRepo.saveAll(Arrays.asList(ende1, ende2));*/
		
		
		
		
	}

}

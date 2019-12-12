package com.gustavo.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.domain.Cidade;
import com.gustavo.cursomc.domain.Cliente;
import com.gustavo.cursomc.domain.Endereco;
import com.gustavo.cursomc.domain.Estado;
import com.gustavo.cursomc.domain.Pagamento;
import com.gustavo.cursomc.domain.PagamentoComBoleto;
import com.gustavo.cursomc.domain.PagamentoComCartao;
import com.gustavo.cursomc.domain.Pedido;
import com.gustavo.cursomc.domain.Produtos;
import com.gustavo.cursomc.domain.enuns.EstadoPagamento;
import com.gustavo.cursomc.domain.enuns.TipoCliente;
import com.gustavo.cursomc.repositories.CategoriaRepository;
import com.gustavo.cursomc.repositories.CidadeRepository;
import com.gustavo.cursomc.repositories.ClienteRepository;
import com.gustavo.cursomc.repositories.EnderecoRepository;
import com.gustavo.cursomc.repositories.EstadoRepository;
import com.gustavo.cursomc.repositories.PagamentoRepository;
import com.gustavo.cursomc.repositories.PedidoRepository;
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
	
	//Pedido
	
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired 
	private PagamentoRepository pagamentoRepo;
	
	
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
		
		Cliente cli1 = new Cliente(null, "Cassia Ferreira", "cassia.rocha.240966@hotmail.com", "36378912377", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cida1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cida2);

	
		cli1.getEndereco().addAll(Arrays.asList(e1, e2));

		clienteRepo.saveAll(Arrays.asList(cli1));
		endeRepo.saveAll(Arrays.asList(e1, e2));
		
		// Pedido
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepo.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepo.saveAll(Arrays.asList(pagto1, pagto2));
		
	}

}

package br.com.rodolfo.loja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rodolfo.loja.domain.Categoria;
import br.com.rodolfo.loja.domain.Cidade;
import br.com.rodolfo.loja.domain.Cliente;
import br.com.rodolfo.loja.domain.Endereco;
import br.com.rodolfo.loja.domain.Estado;
import br.com.rodolfo.loja.domain.Produto;
import br.com.rodolfo.loja.domain.enums.TipoCliente;
import br.com.rodolfo.loja.repositories.CategoriaRepository;
import br.com.rodolfo.loja.repositories.CidadeRepository;
import br.com.rodolfo.loja.repositories.ClienteRepository;
import br.com.rodolfo.loja.repositories.EnderecoRepository;
import br.com.rodolfo.loja.repositories.EstadoRepository;
import br.com.rodolfo.loja.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));


		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria", "teste@teste.com", "10564414742", TipoCliente.PESSOA_FISICA);

		cli1.getTelefones().addAll(Arrays.asList("34545212", "398741251"));
		
		Endereco end1 = new Endereco(null, "Águas de Março", "200", "casa", "etelvina", "31746852", cli1, c1);
		Endereco end2 = new Endereco(null, "Garota de Ipanema", "320", "casa", "pampulha", "21478521", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

	}

}

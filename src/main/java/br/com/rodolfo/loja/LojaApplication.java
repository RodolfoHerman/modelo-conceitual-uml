package br.com.rodolfo.loja;

import java.text.SimpleDateFormat;
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
import br.com.rodolfo.loja.domain.Pagamento;
import br.com.rodolfo.loja.domain.PagamentoBoleto;
import br.com.rodolfo.loja.domain.PagamentoCartao;
import br.com.rodolfo.loja.domain.Pedido;
import br.com.rodolfo.loja.domain.Produto;
import br.com.rodolfo.loja.domain.enums.EstadoPagamento;
import br.com.rodolfo.loja.domain.enums.TipoCliente;
import br.com.rodolfo.loja.repositories.CategoriaRepository;
import br.com.rodolfo.loja.repositories.CidadeRepository;
import br.com.rodolfo.loja.repositories.ClienteRepository;
import br.com.rodolfo.loja.repositories.EnderecoRepository;
import br.com.rodolfo.loja.repositories.EstadoRepository;
import br.com.rodolfo.loja.repositories.PagamentoRepository;
import br.com.rodolfo.loja.repositories.PedidoRepository;
import br.com.rodolfo.loja.repositories.ProdutoRepository;

@SpringBootApplication
public class LojaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido pd1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido pd2 = new Pedido(null, sdf.parse("10/10/2017 19:30"), cli1, end2);

		Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, pd1, 6);
		
		pd1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, pd2, null, sdf.parse("20/10/2017 00:00"));

		pd2.setPagamento(pag2);

		cli1.getPedidos().addAll(Arrays.asList(pd1, pd2));

		pedidoRepository.saveAll(Arrays.asList(pd1, pd2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
	}

}

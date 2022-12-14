package classes.testes;

import java.util.*;

import classes.contatos.Telefone;
import classes.dao.PessoaFisicaDAO;
import classes.pedidos.*;
import classes.pessoas.PessoaFisica;
import classes.util.Situacao;

public class TesteMapeamento2 {

	public static void main(String[] args) {

		PessoaFisica pessoa1 = new PessoaFisica();
		pessoa1.setNome("Miguel");
		pessoa1.setCpf("123456789-10");
		pessoa1.setEndereco("Rua do IFRS");
		pessoa1.setTelefone(new Telefone(51, 33332222));
		pessoa1.setData();

		PessoaFisica pessoa2 = new PessoaFisica("Shenka, a cadela", "000.000.000-00", "Caminha", 51, 999999999);
		pessoa2.setData();

		List<String> emails1 = new ArrayList<String>();
		emails1.add("miguel@email.com");
		emails1.add("miguelzk@email.com");
		pessoa1.setEmails(emails1);

		List<String> emails2 = new ArrayList<String>();
		emails2.add("shenka@email.com");
		emails2.add("mondonga@email.com");
		pessoa2.setEmails(emails2);

		Pedido pedido1Pessoa1 = new Pedido();
		Pedido pedido2Pessoa1 = new Pedido();
		Pedido pedidoShenka = new Pedido();

		ItemPedido varal = new ItemPedido();
		varal.setDescricao("Varal");
		varal.setQuantidade(2);
		varal.setValorUnitario(40.5);

		ItemPedido vassoura = new ItemPedido("Vassoura", 20.75, 3);

		ItemPedido cuia = new ItemPedido("Cuia", 15.0, 1);
		ItemPedido bomba = new ItemPedido("Bomba de chimarrão", 31.2, 1);
		ItemPedido erva = new ItemPedido("Erva Mate", 15.0, 2);

		List<ItemPedido> itensPed1Pes1 = new ArrayList<ItemPedido>();
		itensPed1Pes1.add(varal);
		itensPed1Pes1.add(vassoura);

		List<ItemPedido> itensPed2Pes1 = new ArrayList<ItemPedido>();
		itensPed2Pes1.add(cuia);
		itensPed2Pes1.add(bomba);
		itensPed2Pes1.add(erva);

		pedido1Pessoa1.setData(new Date());
		pedido1Pessoa1.setItens(itensPed1Pes1);
		pedido1Pessoa1.setSituacao(Situacao.CANCELADO);

		pedido2Pessoa1.setData(new Date());
		pedido2Pessoa1.setItens(itensPed2Pes1);
		pedido2Pessoa1.setSituacao(Situacao.AGUARDANDO);

		List<Pedido> pedidosPes1 = new ArrayList<Pedido>();
		pedidosPes1.add(pedido1Pessoa1);
		pedidosPes1.add(pedido2Pessoa1);
		pessoa1.setPedidos(pedidosPes1);

		ItemPedido pratoComidinha = new ItemPedido("Prato Comidinha", 15.85, 1);
		ItemPedido racao = new ItemPedido("Comiiiiiiida 1kg", 25.3, 4);
		ItemPedido caminha = new ItemPedido("Minha caminha", 120.0, 1);

		List<ItemPedido> itensPed1Shenka = new ArrayList<ItemPedido>();
		itensPed1Shenka.add(pratoComidinha);
		itensPed1Shenka.add(racao);
		itensPed1Shenka.add(caminha);

		pedidoShenka.setData(new Date());
		pedidoShenka.setItens(itensPed1Shenka);
		pedidoShenka.setSituacao(Situacao.ANDAMENTO);

		List<Pedido> pedidosShenka = new ArrayList<Pedido>();
		pedidosShenka.add(pedidoShenka);
		pessoa2.setPedidos(pedidosShenka);

		PessoaFisicaDAO pesDAO1 = new PessoaFisicaDAO();
		
		if (pesDAO1.insert(pessoa1)) {
		System.out.println("Pessoa Física inserida com sucesso"); }
		
		if (pesDAO1.insert(pessoa2)) {
		System.out.println("Pessoa Física inserida com sucesso"); }
		
		List<PessoaFisica> todos = pesDAO1.listAll();
		for (PessoaFisica pf : todos) {
			System.out.println(pf);
			System.out.println("-------------------------");
		}
	}

}

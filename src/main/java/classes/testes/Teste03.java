package classes.testes;

import java.util.*;

import classes.dao.PessoaJuridicaDAO;
import classes.pedidos.*;
import classes.pessoas.PessoaJuridica;
import classes.util.Situacao;

public class Teste03 {

	public static void main(String[] args) {

		PessoaJuridica obspoa1 = new PessoaJuridica("ObservaPOA", "12.345.678-0001/01", "Rua Siqueira Campos", 51, 32163216);
		obspoa1.setData();

		Set<String> emails1 = new HashSet<String>();
		emails1.add("obspoa@email.com");
		emails1.add("observatorio@email.com");
		obspoa1.setEmails(emails1);

		Pedido pedidoObspoa1 = new Pedido();
		Pedido pedidoObspoa2 = new Pedido();

		ItemPedido canetaAzul = new ItemPedido("Caneta Azul", 3, 50);
		ItemPedido canetaVerm = new ItemPedido("Caneta Vermelha", 3, 50);
		ItemPedido canetaPreta = new ItemPedido("Caneta Preta", 3, 50);

		ItemPedido papelA4 = new ItemPedido("Papel 500 folhas", 35.5, 5);
		ItemPedido papelA3 = new ItemPedido("Papel 200 folhas", 40.5, 2);

		List<ItemPedido> itensPed1 = new ArrayList<ItemPedido>();
		itensPed1.add(canetaAzul);
		itensPed1.add(canetaVerm);
		itensPed1.add(canetaPreta);
		
		List<ItemPedido> itensPed2 = new ArrayList<ItemPedido>();
		itensPed2.add(papelA4);
		itensPed2.add(papelA3);

		pedidoObspoa1.setData(new Date());
		pedidoObspoa1.setItens(itensPed1);
		pedidoObspoa1.setSituacao(Situacao.ANDAMENTO);

		pedidoObspoa2.setData(new Date());
		pedidoObspoa2.setItens(itensPed2);
		pedidoObspoa2.setSituacao(Situacao.AGUARDANDO);
		
		List<Pedido> pedidosObsPOA = new ArrayList<Pedido>();
		pedidosObsPOA.add(pedidoObspoa1);
		pedidosObsPOA.add(pedidoObspoa2);
		obspoa1.setPedidos(pedidosObsPOA);
		
		PessoaJuridicaDAO pesDAO1 = new PessoaJuridicaDAO();
		
		if (pesDAO1.insert(obspoa1)) {
			System.out.println("Pessoa Física inserida com sucesso");
		}
		
//		obspoa1.setEndereco("Rua Joao Manoel");
//		if (pesDAO1.update(obspoa1)) {
//			System.out.println("Cadastro atualizado com sucesso");
//		}
	}

}

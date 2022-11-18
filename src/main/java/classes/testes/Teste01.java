package classes.testes;

import java.util.*;

import classes.contatos.Telefone;
import classes.dao.PessoaFisicaDAO;
import classes.pedidos.*;
import classes.pessoas.PessoaFisica;

public class Teste01 {

	public static void main(String[] args) {

		PessoaFisica pessoa1 = new PessoaFisica();
		pessoa1.setNome("Miguel");
		pessoa1.setCpf("123456789-10");
		pessoa1.setEndereco("Rua do IFRS");
		pessoa1.setTelefone(new Telefone(51, 33332222));

		Set<String> emails = new HashSet<String>();
		emails.add("miguel@email.com");
		emails.add("miguelzk@email.com");
		pessoa1.setEmails(emails);

		Pedido pedido1 = new Pedido();

		ItemPedido varal = new ItemPedido();
		varal.setDescricao("Varal");
		varal.setQuantidade(2);
		varal.setValorUnitario(40.5);
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		itens.add(varal);

		pedido1.setData(new Date());
		pedido1.setItens(itens);

		double valorPedido = 0.0;
		for (ItemPedido item : itens) {
			valorPedido += item.getValorUnitario() * item.getQuantidade();
		}

//		double valorPedido = itens.stream()
//				.reduce(0D, (double subtotal, ItemPedido item.get) -> 1);

		pedido1.setValor(valorPedido);
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(pedido1);
		pessoa1.setPedidos(pedidos);

		PessoaFisicaDAO doItMother = new PessoaFisicaDAO();

		if (doItMother.insert(pessoa1)) {
			System.out.println("Pessoa Física inserida com sucesso");
		}
	}

}

package classes.testes;

import classes.dao.ItemPedidoDAO;
import classes.pedidos.*;

public class TesteMapeamento4 {

	public static void main(String[] args) {

		ItemPedidoDAO objDAO1 = new ItemPedidoDAO();

		if (objDAO1.remove(2L)) {
			System.out.println("Cadastro removido com sucesso");
		}
		ItemPedido item = new ItemPedido("Varal de novo", 40.5, 2);
		item.setIdItem(2L);

		if (objDAO1.insert(item)) {
			System.out.println("Item inserido com sucesso (mas sem vínculos afetivos com pessoa nenhuma)");
		}

		if (objDAO1.remove(2L)) {
			System.out.println("Cadastro removido com sucesso");
		}
	}

}

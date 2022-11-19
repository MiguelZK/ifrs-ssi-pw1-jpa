package classes.testes;

import java.util.List;

import classes.contatos.Telefone;
import classes.dao.ItemPedidoDAO;
import classes.dao.PessoaFisicaDAO;
import classes.dao.TelefoneDAO;
import classes.pedidos.*;
import classes.pessoas.PessoaFisica;

public class TesteMapeamento5 {

	public static void main(String[] args) {

		PessoaFisicaDAO objDAO1 = new PessoaFisicaDAO();		
		PessoaFisica pf = objDAO1.find(3L);
		
		pf.setNome("Outro Nome");

		if (pf != null && objDAO1.update(pf)) {
			System.out.println("Nome alterado da pessoa com id referenciado");
		}
		
		List<PessoaFisica> pfs = objDAO1.findAll("Miguel");
		for(PessoaFisica pesfis : pfs) {
			System.out.println(pesfis);
		}
		
		TelefoneDAO telDAO1 = new TelefoneDAO(); 
		
		List<Telefone> tels = telDAO1.findAll(33332222L);
		for(Telefone tel : tels) {
			System.out.println(tel);
		}
	}
}

package classes.testes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import classes.contatos.Telefone;
import classes.dao.PessoaFisicaDAO;
import classes.pessoas.PessoaFisica;

public class Teste00 {
	

	public static void main(String[] args) {
		 
		PessoaFisica pessoa1 = new PessoaFisica();
		
		pessoa1.setNome("Miguel");
		pessoa1.setCpf("123456789-10");
		pessoa1.setTelefone(new Telefone(51, 33332222));
		
		Set<String> emails = new HashSet<String>();
		emails.add("miguel@email.com");
		emails.add("miguelzk@email.com");
		
		pessoa1.setEmails(emails);
		
		if(new PessoaFisicaDAO().insert(pessoa1)) {
			System.out.println("Pessoa Física inserida com sucesso");
		}

	}

}

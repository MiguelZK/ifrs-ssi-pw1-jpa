package classes.pessoas;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.List;

import javax.persistence.Entity;

import classes.dao.PessoaFisicaDAO;
import classes.pedidos.Pedido;

@Entity
public class PessoaFisica extends Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;

	public PessoaFisica() {}

	public PessoaFisica(String nome, String cpf, String endereco, int ddd, long numfone) {
		this(nome, cpf, endereco, ddd, numfone, null);
	}

	public PessoaFisica(String nome, String cpf, String endereco, int ddd, long numfone, List<Pedido> pedidos) {
		super(endereco, ddd, numfone, pedidos);
		this.nome = nome;
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "\nCadastro " + this.getId() + "\nPessoa Física" + "\nNome: " + nome + "\nCPF: " + cpf
				+ super.toString();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, nome);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome);
	}

}

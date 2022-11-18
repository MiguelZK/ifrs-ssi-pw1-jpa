package classes.pessoas;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;

import classes.dao.PessoaJuridicaDAO;
import classes.pedidos.Pedido;

@Entity
public class PessoaJuridica extends Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private String razaoSocial;
	private String cnpj;

	public PessoaJuridica() {}

	public PessoaJuridica(String razaoSocial, String cnpj, String endereco, int ddd, long numfone, Set<Pedido> pedidos) {
		super(endereco, ddd, numfone, pedidos);
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "\nCadastro " + this.getId() + "\nPessoa Física" + "\nRazaoSocial: " + razaoSocial + "\nCPF: " + cnpj
				+ super.toString();
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj, razaoSocial);
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
		PessoaJuridica other = (PessoaJuridica) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(razaoSocial, other.razaoSocial);
	}

	public boolean insert() {
		return new PessoaJuridicaDAO().insert(this);
	}

	public TreeSet<PessoaJuridica> listAll() {
		TreeSet<PessoaJuridica> pessoas = new TreeSet<>();
		pessoas.addAll(new PessoaJuridicaDAO().listAll());
		System.out.println("------------------------");
		return pessoas;
	}

	public boolean update() {
		return new PessoaJuridicaDAO().update(this);
	}

}

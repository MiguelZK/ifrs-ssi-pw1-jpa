package classes.pessoas;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import classes.contatos.Telefone;
import classes.pedidos.Pedido;
//import dao.ClienteDAO;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String endereco;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private java.util.Date data;
	
//	@CollectionTable(name="emails_do_cliente")
	@ElementCollection
	private Set<String> emails;
	
//	@Column(nullable = false)
	@OneToOne (cascade = CascadeType.PERSIST, orphanRemoval = true)
	private Telefone telefone;
	
//	@Column(nullable = false)
	@OneToMany (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_cliente")
	private Set<Pedido> pedidos;

	public Cliente() {}
	
	public Cliente(String endereco, int ddd, long numfone, Set<Pedido> pedidos) {
		this(endereco, null, ddd, numfone, pedidos);
	}	

	public Cliente(String endereco, Set<String> emails, int ddd, long numfone, Set<Pedido> pedidos) {
		this.endereco = endereco;
		this.data = new Date();
		this.emails = emails;
		this.telefone = new Telefone(ddd, numfone);
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", endereco=" + endereco + ", data=" + data + ", emails=" + emails + ", telefone="
				+ telefone + ", pedidos=" + pedidos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public java.util.Date getDataHora() {
		return data;
	}

	public void setData() {
		this.data = new Date();
	}

	public void setData(int dia, int mes, int ano) {
		this.data = new Date(ano, mes, dia);
	}
	
//	public boolean remove(Long id) {
//		return new ClienteDAO().remove(id);
//	}

}

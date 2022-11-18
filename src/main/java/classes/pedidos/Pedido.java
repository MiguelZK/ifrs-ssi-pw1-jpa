package classes.pedidos;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import classes.util.Situacao;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_pedido", nullable = false)
	private Date data;

	private double valor;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "numero")
	private Set<ItemPedido> itens;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public Pedido() {
	}

	public Pedido(Date data, double valor, Set<ItemPedido> itens, Situacao situacao) {
		this.data = data;
		this.valor = valor;
		this.itens = itens;
		this.situacao = situacao;
	}

	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
		calculaValorPedido();
	}

	public Situacao getSituacao() {
		return situacao;
	}
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public void calculaValorPedido() {
		double valorPedido = 0.0;
		for (ItemPedido item : this.itens) {
			valorPedido += item.getValorUnitario() * item.getQuantidade();
		}
		this.setValor(valorPedido);
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", data=" + data + ", valor=" + valor + ", itens=" + itens + ", situacao="
				+ situacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(numero, other.numero);
	}

}

package classes.pedidos;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ItemPedido
 *
 */
@Entity

public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	private String descricao;   
	private double valorUnitario;
	private int quantidade;

	public ItemPedido() {}
	
	public ItemPedido(String descricao, double valorUnitario, int quantidade) {
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "ItemPedido [idItem=" + idItem + ", descricao=" + descricao + ", valorUnitario=" + valorUnitario
				+ ", quantidade=" + quantidade + "]";
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Long getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}   
	public double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}   
	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, quantidade, valorUnitario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(descricao, other.descricao) && quantidade == other.quantidade
				&& Double.doubleToLongBits(valorUnitario) == Double.doubleToLongBits(other.valorUnitario);
	}
   
}

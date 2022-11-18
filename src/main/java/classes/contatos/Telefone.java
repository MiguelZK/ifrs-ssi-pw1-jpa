package classes.contatos;

import javax.persistence.Entity;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Miguel Zanona Krasner Entity implementation class for Entity: Cliente
 */
@Entity
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_telefone;
	private int ddd;
	private long numfone;

	public Telefone() {}

	public Telefone(int ddd, long numfone) {
		this.ddd = ddd;
		this.numfone = numfone;
	}

	@Override
	public String toString() {
		return " | Telefone: (" + ddd + ") " + numfone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public long getNumfone() {
		return numfone;
	}

	public void setNumfone(long numfone) {
		this.numfone = numfone;
	}

	public int getId_telefone() {
		return id_telefone;
	}

	/*
	 * public void setId_telefone(int id_telefone) { this.id_telefone = id_telefone;
	 * }
	 */

	@Override
	public int hashCode() {
		return Objects.hash(ddd, numfone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return ddd == other.ddd && numfone == other.numfone;
	}
}

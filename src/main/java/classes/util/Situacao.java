package classes.util;

/*
 * @author  Miguel Zanona Krasner
 * 
 * */

public enum Situacao {
	ANDAMENTO(1, "Em andamento"), CANCELADO(2, "Cancelado"), AGUARDANDO(3, "Aguardando");

	private final int id;
	private final String descricao;

	private Situacao(int valorId, String descricao) {
		id = valorId;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getId() + " - " + this.getDescricao();
	}
}
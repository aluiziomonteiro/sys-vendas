package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 */
public class Estoque {
	private Integer id;
	private Integer qtdEntrada = 0;
	private Integer qtdSaida = 0;
	private Integer qtdMinima = 0;
	private Integer qtdDisponivel = 0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdEntrada() {
		return qtdEntrada;
	}

	public void setQtdEntrada(Integer qtdEntrada) {
		this.qtdEntrada = qtdEntrada;
	}

	public Integer getQtdSaida() {
		return qtdSaida;
	}

	public void setQtdSaida(Integer qtdSaida) {
		this.qtdSaida = qtdSaida;
	}

	public Integer getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(Integer qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	public Integer getQtdDisponivel() {
		return qtdDisponivel;
	}

	public void setQtdDisponivel(Integer qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", qtdEntrada=" + qtdEntrada + ", qtdSaida=" + qtdSaida + ", qtdMinima="
				+ qtdMinima + ", qtdDisponivel=" + qtdDisponivel + "]";
	}
	
	



}

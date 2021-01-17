package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;

/**
 * Investimento.java
 * @author Aluizio Monteiro
 * 11 de mai de 2019
 */

public class Investimentos {
	private BigDecimal valorTotal = new BigDecimal("00.00");
	private int mes;
	private int ano;
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	@Override
	public String toString() {
		return "Investimento [valorTotal=" + valorTotal + ", mes=" + mes + ", ano=" + ano + "]";
	}
	
	
}

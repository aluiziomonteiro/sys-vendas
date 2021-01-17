package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * AReceber.java
 * 
 * @author Aluizio Monteiro 22 de mai de 2019
 */

public class Dividas {

	private Integer idOrcamento;
	private String nomeCliente;
	private BigDecimal valorParcela;
	private LocalDate dataVencimento;

	public Integer getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(Integer idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "Dividas [idOrcamento=" + idOrcamento + ", nomeCliente=" + nomeCliente + ", valorParcela="
				+ valorParcela + ", dataVencimento=" + dataVencimento + "]";
	}

}
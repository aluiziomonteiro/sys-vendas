package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Aluizio Monteiro
 */
public class Pagamentos implements Comparable<LocalDate> {
	private Integer id;
	private Integer numParcela = 0;
	private BigDecimal valorParcela = new BigDecimal("0.00");
	private LocalDate parcelaData; // vencimento
	private Integer fkOrcamento;
	private EnumStatus status;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(Integer numParcela) {
		this.numParcela = numParcela;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public LocalDate getParcelaData() {
		return parcelaData;
	}

	public void setParcelaData(LocalDate parcelaData) {
		this.parcelaData = parcelaData;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public Integer getFkOrcamento() {
		return fkOrcamento;
	}

	public void setFkOrcamento(Integer fkOrcamento) {
		this.fkOrcamento = fkOrcamento;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", numParcela=" + numParcela + ", valorParcela=" + valorParcela
				+ ", parcelaData=" + parcelaData + ", fkOrcamento=" + fkOrcamento + ", status=" + status + "]";
	}

	@Override
	public int compareTo(LocalDate data) {
		if(this.parcelaData.equals(data)) {
			return 1;
		}
		return 0;
	}
	
	

}

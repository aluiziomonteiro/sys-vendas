package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Aluizio Monteiro Esta classe formará uma lista de produtos do
 *         orçamento. cada ocorrencia de produto possui um id do cliente
 *         associado. Ela guarda os ítens exibidos na JSP "sessão"
 */

public class Carrinho {
	private Integer produtoId;
	private Integer orcamentoId;
	private String produtoNome;
	private Integer qtd = 0;
	private BigDecimal valorUnid = new BigDecimal("0.00");
	private BigDecimal subTotal = new BigDecimal("0.00");
	private BigDecimal custo = new BigDecimal("0.00");
	
	private LocalDate data;

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getOrcamentoId() {
		return orcamentoId;
	}

	public void setOrcamentoId(Integer orcamentoId) {
		this.orcamentoId = orcamentoId;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getValorUnid() {
		return valorUnid;
	}

	public void setValorUnid(BigDecimal valorUnid) {
		this.valorUnid = valorUnid;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Carrinho [produtoId=" + produtoId + ", orcamentoId=" + orcamentoId + ", produtoNome=" + produtoNome
				+ ", qtd=" + qtd + ", valorUnid=" + valorUnid + ", subTotal=" + subTotal + ", custo=" + custo
				+ ", data=" + data + "]";
	}
	
	
}

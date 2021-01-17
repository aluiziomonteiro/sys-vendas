package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Orcamento.java
 * 
 * @author Aluizio Monteiro 24 de nov de 2018
 */

public class Orcamento {
	private Integer id;
	private Integer totalParcelas = 0;
	private Integer parcelasPagas = 0;
	private Integer parcelasAPagar = 0; 
	private Cliente cliente;
	private Usuario usuario;
	private BigDecimal subTotalOrcamento = new BigDecimal("0.00");
	private BigDecimal descontos = new BigDecimal("0.00");
	private BigDecimal totalOrcamento = new BigDecimal("0.00");

	private LocalDate dataLancamento;
	
	private List<Carrinho> list;
	private List<Pagamentos> pagamentos;
	private BigDecimal custo = new BigDecimal("0.00");;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalParcelas() {
		return totalParcelas;
	}

	public void setTotalParcelas(Integer totalParcelas) {
		this.totalParcelas = totalParcelas;
	}

	public Integer getParcelasPagas() {
		return parcelasPagas;
	}

	public void setParcelasPagas(Integer parcelasPagas) {
		this.parcelasPagas = parcelasPagas;
	}

	public Integer getParcelasAPagar() {
		return parcelasAPagar;
	}

	public void setParcelasAPagar(Integer parcelasAPagar) {
		this.parcelasAPagar = parcelasAPagar;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getDescontos() {
		return descontos;
	}

	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}

	public BigDecimal getTotalOrcamento() {
		return totalOrcamento;
	}

	public void setTotalOrcamento(BigDecimal totalOrcamento) {
		this.totalOrcamento = totalOrcamento;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public List<Carrinho> getList() {
		return list;
	}

	public void setList(List<Carrinho> list) {
		this.list = list;
	}

	public List<Pagamentos> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamentos> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public BigDecimal getSubTotalOrcamento() {
		return subTotalOrcamento;
	}

	public void setSubTotalOrcamento(BigDecimal subTotalOrcamento) {
		this.subTotalOrcamento = subTotalOrcamento;
	}
	

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	
	public BigDecimal getCusto() {
		return this.custo;
	}

	@Override
	public String toString() {
		return "Orcamento [id=" + id + ", totalParcelas=" + totalParcelas + ", parcelasPagas=" + parcelasPagas
				+ ", parcelasAPagar=" + parcelasAPagar + ", cliente=" + cliente + ", usuario=" + usuario
				+ ", subTotalOrcamento=" + subTotalOrcamento + ", descontos=" + descontos + ", totalOrcamento="
				+ totalOrcamento + ", dataLancamento=" + dataLancamento + ", list=" + list + ", pagamentos="
				+ pagamentos + ", custo="+ custo +"]";
	}




	
}
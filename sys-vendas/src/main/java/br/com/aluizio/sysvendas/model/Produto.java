package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;

/**
 * @author Aluizio Monteiro novo
 */
public class Produto extends Categoria {
	private Integer id;
	private String nome;
	private String descricao;
	private String indicacao;
	private String volume;
	private BigDecimal custoUnid = new BigDecimal("0.00");
	private BigDecimal sugestaoVenda = new BigDecimal("0.00");
	private BigDecimal lucro = new BigDecimal("0.00");
	private double percentual = 0.0;
	
	private String imagem;

	private Estoque estoque;
	private Categoria categoria;
	private Fornecedor fornecedor;

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	
	public BigDecimal getCustoUnid() {
		return custoUnid;
	}

	public void setCustoUnid(BigDecimal custoUnid) {
		this.custoUnid = custoUnid;
	}

	public BigDecimal getSugestaoVenda() {
		return sugestaoVenda;
	}

	public void setSugestaoVenda(BigDecimal sugestaoVenda) {
		this.sugestaoVenda = sugestaoVenda;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", indicacao=" + indicacao
				+ ", volume=" + volume + ", custoUnid=" + custoUnid + ", sugestaoVenda=" + sugestaoVenda + ", lucro="
				+ lucro + ", percentual=" + percentual + ", imagem=" + imagem + ", estoque=" + estoque + ", categoria="
				+ categoria + ", fornecedor=" + fornecedor + "]";
	}
	

	
}

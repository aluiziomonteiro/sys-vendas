package br.com.aluizio.sysvendas.model;

/**
 * ProdutoFornecedor.java
 * 
 * @author Aluizio Monteiro 28 de ago de 2018
 */

public class ProdutoFornecedor {
	private int idProduto;
	private int idFornecedor;

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	@Override
	public String toString() {
		return "ProdutoFornecedor [idProduto=" + idProduto + ", idFornecedor=" + idFornecedor + "]";
	}

}

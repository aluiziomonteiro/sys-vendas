package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaProdutosEsgotados.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class ProdutosEsgotados {

	/**
	 * Produtos Esgotado
	 * @return List<Produto> esgotadoList
	 */
	
	public static List<Produto> getProdutosEsgotados() {
		ProdutoDao produtoDao = new ProdutoDao();
		List<Produto> esgotadoList = produtoDao.esgotadoList();
		return esgotadoList;
	}

}

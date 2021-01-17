package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaProdutoTopList.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class ProdutoTopList {

	/**
	 * Produtos Top List
	 * 
	 * @return List<Produto> topList
	 */
	public static List<Produto> getProdutoTopList() {
		ProdutoDao produtoDao = new ProdutoDao();
		List<Produto> topList = produtoDao.topList();
		return topList;
	}

}

package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * ProdutosReserva.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class ProdutosReserva {

	/**
	 * Lista de produtos na reserva
	 * 
	 * @return List<Produto> reservaList
	 */
	public static List<Produto> getProdutosReserva() {
		ProdutoDao produtoDao = new ProdutoDao();
		List<Produto> reservaList = produtoDao.reservaList();
		return reservaList;
	}

}

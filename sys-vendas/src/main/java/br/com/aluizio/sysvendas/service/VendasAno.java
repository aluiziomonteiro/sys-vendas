package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Vendas;

/**
 * TestaBuscaVendasAno.java
 * 
 * @author Aluizio Monteiro 27 de abr de 2019
 */

public class VendasAno {
	/**
	 * Vendas Ordenadas por Ano
	 * 
	 * @return List<Vendas> vendasMes
	 */
	public static List<Vendas> buscaVendasAno() {
		List<Vendas> vendasAno = new OrcamentoDao().getVendasAno();
		return vendasAno;
	}
}

package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Vendas;

/**
 * VendasMes.java
 * 
 * @author Aluizio Monteiro 27 de abr de 2019
 */

public class VendasMes {
	/**
	 * Listar Vendas ordenadas por mês
	 * 
	 * @return List<Vendas> vendasMes
	 */
	public static List<Vendas> buscaVendasMes() {
		List<Vendas> vendasMes = new OrcamentoDao().getVendasMes();
		return vendasMes;
	}
}

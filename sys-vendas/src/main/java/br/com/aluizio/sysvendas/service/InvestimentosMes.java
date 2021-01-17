package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.CarrinhoDao;
import br.com.aluizio.sysvendas.model.Investimentos;

/**
 * InvestimentosMes.java
 * @author Aluizio Monteiro
 * 11 de mai de 2019
 */

public class InvestimentosMes {
	/**
	 * Listar Investimentos ordenados por mês
	 * 
	 * @return List<Investimentos> InvestimentosMes
	 */
	public static List<Investimentos> buscaInvestimentosMes() {
		List<Investimentos> vendasMes = new CarrinhoDao().getInvestimentosMes();
		return vendasMes;
	}
}


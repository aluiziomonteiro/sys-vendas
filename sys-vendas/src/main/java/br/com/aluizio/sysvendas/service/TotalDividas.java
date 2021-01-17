package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Dividas;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TotalDividas.java
 * 
 * @author Aluizio Monteiro 
 * @date 25 de abr de 2019
 */

public class TotalDividas {
	/**
	 * Valor total d�vidas
	 * 
	 * @return BigDecimal valorTotal
	 */
	public static BigDecimal getListDividas(List<Pagamentos> buscaDividas) {
		BigDecimal valorTotal = new BigDecimal("0.00");
		valorTotal = buscaDividas.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		if (valorTotal == null || valorTotal == BigDecimal.ZERO) {
			valorTotal = new BigDecimal("0.00");
		}
		return valorTotal;
	}

	/**
	 * Listar todas as d�vidas
	 * 
	 * @return Lista de D�vidas
	 */
	public static List<Pagamentos> getDividas() {
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> buscaDividas = pagamentoDao.buscaDividas();
		return buscaDividas;
	}

	/**
	 * Listar todas as d�vidas atrasadas
	 * 
	 * @return BigDecimal dividasAtrasadas
	 */
	public static List<Dividas> getDividasAtrasadas() {
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Dividas> dividasAtrasadas = pagamentoDao.buscaDividasAtrasadas();
		return dividasAtrasadas;
	}
	
	/**
	 * Listar todas as d�vidas � receber
	 * 
	 * @return BigDecimal dividasAReceber
	 */
	public static List<Dividas> getDividasAReceber() {
		List<Dividas> dividasAReceber = new PagamentoDao()
				.buscaDividasAReceber();
		return dividasAReceber;
	}
}

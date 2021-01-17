package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaAReceberSemana.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class AReceberSemana {

	/**
	 * Valor á receber Semana
	 * 
	 * @return BigDecimal totalAReceberSemana
	 */
	public static BigDecimal getValorAReceberSemana(List<Pagamentos> listaAReceberSemana) {
		BigDecimal totalAReceberSemana = listaAReceberSemana.stream().map(Pagamentos::getValorParcela)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		if (totalAReceberSemana == null || totalAReceberSemana == BigDecimal.ZERO) {
			totalAReceberSemana = new BigDecimal("0.00");
		}
		
		return totalAReceberSemana;
	}

	/**
	 * Lista á receber Semana
	 * 
	 * @return List listaAReceberSemana
	 */
	public static List<Pagamentos> getListaAReceberSemana() {
		List<Pagamentos> listaAReceberSemana = new PagamentoDao().buscaDividasSemana();
		return listaAReceberSemana;
	}

}

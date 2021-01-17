package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * AReceber.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class AReceber {

	/**
	 * Valor total Atraso
	 * @return BigDecimal totalAReceber
	 */
	public static BigDecimal getValorTotalAtraso(List<Pagamentos> listaAReceber) {
		BigDecimal totalAReceber = listaAReceber.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
		BigDecimal::add);
		if (totalAReceber == null || totalAReceber == BigDecimal.ZERO) {
			totalAReceber = new BigDecimal("0.00");
		}
		return totalAReceber;
	}

	/**
	 * Lista de Valores à receber
	 * @return List listaAReceber
	 */
	public static List<Pagamentos> getListaValoresAReceber() {
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> listaAReceber = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getStatus().equals(EnumStatus.A_PAGAR)).collect(Collectors.toList());
		listaAReceber.forEach(e -> System.out.println(e));
		return listaAReceber;
	}
}

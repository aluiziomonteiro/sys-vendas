package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * AReceberMes.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class AReceberMes {
	/**
	 * Valor total a receber mês
	 * @return BigDecimal totalAReceberMes
	 */
	public static BigDecimal getValorAReceberMes(List<Pagamentos> listaAReceberMes) {
		// 
		BigDecimal totalAReceberMes = listaAReceberMes.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		
		if (totalAReceberMes == null || totalAReceberMes == BigDecimal.ZERO) {
			totalAReceberMes = new BigDecimal("0.00");
		}
		return totalAReceberMes;
	}

	/**
	 * Lista á receber mês
	 * @return List listaAReceberHoje
	 */
	public static List<Pagamentos> getListAReceberMes() {
		LocalDate hoje = LocalDate.now();
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> listaAReceberMes = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getParcelaData().getMonth().compareTo(hoje.getMonth()) == 0)
				.collect(Collectors.toList());
		return listaAReceberMes;
	}
}

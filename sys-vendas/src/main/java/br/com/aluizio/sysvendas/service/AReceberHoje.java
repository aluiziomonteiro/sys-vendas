package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * AReceberHoje.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class AReceberHoje {
	/**
	 * Valor total a receber hoje
	 * @return BigDecimal totalAReceberHoje
	 */
	public static BigDecimal getValorAReceberHoje(List<Pagamentos> listaAReceberHoje) {
		BigDecimal totalAReceberHoje = listaAReceberHoje.stream().map(Pagamentos::getValorParcela)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		if (totalAReceberHoje == null || totalAReceberHoje == BigDecimal.ZERO) {
			totalAReceberHoje = new BigDecimal("0.00");
		}
		return totalAReceberHoje;
	}

	/**
	 * Lista á receber hoje
	 * @return List listaAReceberHoje
	 */
	public static List<Pagamentos> getListAReceberHoje() {
		LocalDate hoje = LocalDate.now();
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> listaAReceberHoje = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getParcelaData()
				.compareTo(hoje) == 0)
				.collect(Collectors.toList());
		listaAReceberHoje.forEach(e -> System.out.println(e));
		return listaAReceberHoje;
	}

}

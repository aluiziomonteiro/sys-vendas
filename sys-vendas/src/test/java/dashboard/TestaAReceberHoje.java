package dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaAReceberHoje.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaAReceberHoje {

	public static void main(String[] args) {
		/// Lista á receber hoje
		System.out.println("- Total a receber hoje");
		LocalDate hoje = LocalDate.now();
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> listaAReceberHoje = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getParcelaData()
				.compareTo(hoje) == 0)
				.collect(Collectors.toList());
		listaAReceberHoje.forEach(e -> System.out.println(e));

		// Valor total a receber hoje
		BigDecimal totalAReceberHoje = listaAReceberHoje.stream().map(Pagamentos::getValorParcela)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("- Total à receber hoje");
		System.out.println(totalAReceberHoje);

	}

}

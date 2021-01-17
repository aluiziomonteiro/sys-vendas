package dashboard;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaTotalAtraso.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaTotalAtraso {

	public static void main(String[] args) {
		// Lista de pagamentos em Atraso
		PagamentoDao pagamentoDao = new PagamentoDao();
		System.out.println("- Pagamentos atrasados");

		List<Pagamentos> listaAtrasos = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getStatus().equals(EnumStatus.EM_ATRASO)).collect(Collectors.toList());
		listaAtrasos.forEach(e -> System.out.println(e));

		// Valor total Atraso
		BigDecimal valorAtraso = listaAtrasos.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		System.out.println("- Total atrasados");
		System.out.println(valorAtraso);

	}

}

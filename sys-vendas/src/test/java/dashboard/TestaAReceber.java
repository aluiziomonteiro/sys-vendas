package dashboard;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaAReceber.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaAReceber {

	public static void main(String[] args) {
		// Lista de Valores à receber
		System.out.println("- Lista à receber");
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> listaAReceber = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getStatus().equals(EnumStatus.A_PAGAR)).collect(Collectors.toList());
		listaAReceber.forEach(e -> System.out.println(e));

		// Valor total Atraso
		BigDecimal totalAReceber = listaAReceber.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		System.out.println("- Total atrasados");
		System.out.println(totalAReceber);

	}

}

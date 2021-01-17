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

public class TestaAReceberMes {

	public static void main(String[] args) {
		// Lista � receber m�s
		System.out.println("- Total a receber m�s");
		LocalDate hoje = LocalDate.now();
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> listaAReceberMes = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getParcelaData().getMonth().compareTo(hoje.getMonth()) == 0)
				.collect(Collectors.toList());
		listaAReceberMes.forEach(e -> System.out.println(e));

		// Valor total a receber m�s
		BigDecimal totalAReceberMes = listaAReceberMes.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		System.out.println("- Total � receber m�s");
		System.out.println(totalAReceberMes);

	}

}

package dashboard;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaAReceberSemana.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaAReceberSemana {

	public static void main(String[] args) {
		// Lista á receber semana
		System.out.println("- Lista a receber semana");
		// LocalDate hoje = LocalDate.now();

		List<Pagamentos> listaAReceberSemana = new PagamentoDao().buscaDividasSemana();
		listaAReceberSemana.forEach(e -> System.out.println(e));

		// Valor total a receber semana
		BigDecimal totalAReceberSemana = listaAReceberSemana.stream().map(Pagamentos::getValorParcela)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("- Total à receber semana");
		System.out.println(totalAReceberSemana);
	}

}

package dashboard;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaTotalDividas.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaTotalDividas {

	public static void main(String[] args) {
		// Dividas
		System.out.println("* D�vidas");
		PagamentoDao pagamentoDao = new PagamentoDao();

		// Total D�vidas
		System.out.println("- Total D�vidas ");
		List<Pagamentos> buscaDividas = pagamentoDao.buscaDividas();
		BigDecimal valorTotal = buscaDividas.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		System.out.println(valorTotal);

		// Listar todas as d�vidas 
		System.out.println("* Lista de dividas");
		buscaDividas.forEach(System.out::println);
	}

}

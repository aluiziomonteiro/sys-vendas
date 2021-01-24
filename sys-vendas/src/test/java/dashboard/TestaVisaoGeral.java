package dashboard;

import java.math.BigDecimal;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.dao.ProdutoDao;

/**
 * TestaVisaoGeral.java
 * 	
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaVisaoGeral {
	
	public static void main(String[] args) {

		System.out.println("Classe TestaVisaoGeral");
		
		// Total Investido
		System.out.println("Total Investido:");
		ProdutoDao produtoDao = new ProdutoDao();
		BigDecimal totalInvestido = (BigDecimal) produtoDao.getTotalInvestido();

		System.out.println(" - Total: " + totalInvestido);

		
		
		
		
		
		
		// Total Lucro ( vendasBrutas - totalInvestido)
		System.out.println("Total Lucro");

		PagamentoDao pagamentoDao = new PagamentoDao();
		BigDecimal totalVendas = new BigDecimal("0.00");
		totalVendas = pagamentoDao.buscaLucro();
		System.out.println(" - Bruto: " + totalVendas);
		System.out.println(" - L�quido: " + totalVendas.subtract(totalInvestido));

		// Extimativa de Lucro
		// Total Lucro ( soma QUITADO, ATRASADO E A_PAGAR e subtrai pelo totalInvestido)
		System.out.println("Extimativa de Lucro");
		BigDecimal extimativaLucro = pagamentoDao.buscaExtimativas();
		System.out.println(" - Bruto: " + (extimativaLucro));
		System.out.println(" - L�quido: " + (extimativaLucro.subtract(totalInvestido)));

	}

}

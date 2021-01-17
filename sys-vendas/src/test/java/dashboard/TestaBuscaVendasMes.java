package dashboard;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Vendas;

/**
 * TestaBuscaVendasMes.java
 * 
 * @author Aluizio Monteiro 
 * @date 26 de abr de 2019
 */

public class TestaBuscaVendasMes {

	public static void main(String[] args) {
		System.out.println(" - Vendas Por Mes: "); 
		buscaVendasMes();
	}

	public static void buscaVendasMes() {
		List<Vendas> vendasMes = new OrcamentoDao().getVendasMes();
		vendasMes.forEach(e->System.out.println(e));
	}
}

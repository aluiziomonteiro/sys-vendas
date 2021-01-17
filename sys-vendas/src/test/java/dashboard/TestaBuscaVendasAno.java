package dashboard;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Vendas;

/**
 * TestaBuscaVendasAno.java
 * 
 * @author Aluizio Monteiro 
 * @date 27 de abr de 2019
 */

public class TestaBuscaVendasAno {

	public static void main(String[] args) {	
		System.out.println(" - Vendas Por Ano: "); 
		buscaVendasAno();
	}

	public static void buscaVendasAno() {
		List<Vendas> vendasMes = new OrcamentoDao().getVendasAno();
		vendasMes.forEach(e->System.out.println(e));
	}
}

package orcamento;

import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Dividas;

/**
 * TestaBuscaDividasAReceberEmAtraso.java
 * @author Aluizio Monteiro
 * 22 de mai de 2019
 */

public class TestaBuscaDividasAReceberEmAtraso {

	public static void main(String[] args) {
		
		List<Dividas> list = new PagamentoDao().buscaDividasAtrasadas();
		for (Dividas dividas : list) {
			System.out.println(dividas);
		}

	}

}

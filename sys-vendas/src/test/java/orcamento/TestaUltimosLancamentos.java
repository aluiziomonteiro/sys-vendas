package orcamento;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * TestaUltimosLancamentos.java
 * @author Aluizio Monteiro
 * 26 de nov de 2018
 */

public class TestaUltimosLancamentos {

	public static void main(String[] args) {

		List<Orcamento> ultimosLancamentos = new OrcamentoDao().ultimosLancamentos();
		
		for (Orcamento orcamento : ultimosLancamentos) {
			System.out.println(orcamento);
		}
		
	}
}

package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * Retorna uma lista com os últimos lançamentos realizados.
 */

public class UltimosOrcamentos {
	
	public static List<Orcamento> ultimosLancamentos() {
		List<Orcamento> orcamentos = new OrcamentoDao().ultimosLancamentos();
		return orcamentos;
	}
}

package orcamento;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * TestaBuscaPorId.java
 * @author Aluizio Monteiro
 * 26 de nov de 2018
 */

public class TestaBuscaOrcamentoPorId {

	public static void main(String[] args) {
		Orcamento orcBuscado = new Orcamento();
		orcBuscado.setId(18);

		OrcamentoDao dao = new OrcamentoDao();
		
		//retorna cliente e respectívos endereços
		Orcamento orcamento = dao.buscaOrcamentoPorId(orcBuscado);
		
		//Imprime tudo
		System.out.println(orcamento);
		// O produto é o carrinho
	}
}

package orcamento;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * Busca orcamentos por cliente
 */

public class TestaBuscaOrcamentoPorCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("");
		OrcamentoDao dao = new OrcamentoDao();
		
		List<Orcamento> list = dao.buscaOrcamentoPorCliente(cliente);
		
		for (Orcamento orcamento : list) {
			System.out.println(orcamento);
		}	
		
		System.out.println("Busca por nome realizada com sucesso");
	}
}












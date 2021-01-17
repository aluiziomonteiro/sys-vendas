package estoque;

import br.com.aluizio.sysvendas.dao.EstoqueDao;
import br.com.aluizio.sysvendas.model.Estoque;

/**
 * TestaAlteraEstoque.java
 * 
 * @author Aluizio Monteiro 20 de ago de 2018
 */

public class TestaAlteraEstoque {

	public static void main(String[] args) {
		// Alterar
		Estoque estoque = new Estoque();
		estoque.setId(27);
		estoque.setQtdEntrada(10);
		estoque.setQtdMinima(10);
		estoque.setQtdSaida(10);
		
		Estoque estoqueBuscado = (Estoque) new EstoqueDao().buscaPorId(estoque);
	
		
		estoque.setQtdEntrada(estoque.getQtdEntrada()+estoqueBuscado.getQtdEntrada());


		EstoqueDao dao = new EstoqueDao();
		dao.adicionaAltera(estoque);

	}

}

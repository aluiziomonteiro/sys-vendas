package estoque;

import br.com.aluizio.sysvendas.dao.EstoqueDao;
import br.com.aluizio.sysvendas.model.Estoque;

/**
 * TestaInsereEstoque.java
 * 
 * @author Aluizio Monteiro 27 de ago de 2018
 */

public class TestaInsereEstoque {

	public static void main(String[] args) {
		// Alterar
		Estoque estoque = new Estoque();

		estoque.setQtdEntrada(20);
		estoque.setQtdMinima(10);
		estoque.setQtdSaida(1);

		EstoqueDao dao = new EstoqueDao();
		dao.adicionaAltera(estoque);
		System.out.println("Estoque adicionado com sucesso");

	}

}

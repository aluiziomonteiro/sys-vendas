package dashboard;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaProdutosEsgotados.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaProdutosEsgotados {

	public static void main(String[] args) {
		// Produtos Esgotado
		System.out.println("Produtos");
		ProdutoDao produtoDao = new ProdutoDao();

		System.out.println("* Esgotados");
		List<Produto> esgotadoList = produtoDao.esgotadoList();
		esgotadoList.forEach(p -> System.out.println(p));
	}

}

/**
 * 
 */
package produto;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * BuscaProdutoPorNome.java
 * 
 * @author Aluizio Monteiro 
 * 20 de ago de 2018
 */

public class BuscaProdutoPorNome {

	public static void main(String[] args) {

		Produto produtoBuscado = new Produto();
		produtoBuscado.setNome("");

		ProdutoDao dao = new ProdutoDao();
		List<Object> produtos = dao.buscaPorNome(produtoBuscado);
		for (Object produto : produtos) {
			System.out.println(produto);
			System.out.println(((Produto) produto).getEstoque());
		}

	}

}

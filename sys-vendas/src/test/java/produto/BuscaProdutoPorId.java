/**
 * 
 */
package produto;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * BuscaProdutoPorNome.java
 * 
 * @author Aluizio Monteiro 
 * 20 de ago de 2018
 */

public class BuscaProdutoPorId {

	public static void main(String[] args) {

		Produto produtoBuscado = new Produto();
		produtoBuscado.setId(19);

		ProdutoDao dao = new ProdutoDao();
		Produto produto = (Produto) dao.buscaPorId(produtoBuscado);

			System.out.println(produto);
	
	}

}

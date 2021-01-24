/**
 * 
 */
package produto;

import java.math.BigDecimal;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaAlteraProduto.java
 * 
 * @author Aluizio Monteiro 20 de ago de 2018
 */

public class TestaAlteraProduto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Altera
		Produto produto = new Produto();
		produto.setNome("ReconstruPilar");
		produto.setDescricao("Reconstrutor Capilar");
		produto.setIndicacao("Queda de cabelo");
		produto.setVolume("200ml");
		produto.setCustoUnid(new BigDecimal("1000"));
		produto.setSugestaoVenda(new BigDecimal("2000"));

		produto.setId(6);

		ProdutoDao dao = new ProdutoDao();
		dao.alterar(produto);
	}

}

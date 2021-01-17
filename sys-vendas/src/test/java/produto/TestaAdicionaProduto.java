package produto;

import java.math.BigDecimal;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaAdicionaProduto.java
 * 
 * @author Aluizio Monteiro 20 de ago de 2018
 */

public class TestaAdicionaProduto {

	public static void main(String[] args) {
		// Testa Adicionar
		Produto produto = new Produto();
		produto.setNome("Creme");
		produto.setDescricao("Creme");
		produto.setIndicacao("Quimico");
		produto.setVolume("200ml");
		produto.setCustoUnid(new BigDecimal("1000"));
		produto.setSugestaoVenda(new BigDecimal("1200"));
		
		ProdutoDao dao = new ProdutoDao();
		dao.adicionaAltera(produto);

		System.out.println("Produto adicionado.");
	}

}

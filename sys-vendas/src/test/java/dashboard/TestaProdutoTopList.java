package dashboard;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaProdutoTopList.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaProdutoTopList {

	public static void main(String[] args) {
		// Produtos Top List
		System.out.println("Produtos");
		ProdutoDao produtoDao = new ProdutoDao();

		System.out.println("* Os cinco mais vendidos");
		List<Produto> topList = produtoDao.topList();
		topList.forEach(p -> System.out.println(p));
	}

}

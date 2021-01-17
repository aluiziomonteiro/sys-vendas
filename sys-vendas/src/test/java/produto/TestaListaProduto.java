package produto;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaListaProduto.java
 * 
 */

public class TestaListaProduto {

	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao();
		List<Object> produtos = dao.getList();	

		for (Object object : produtos) {
			Produto p =  (Produto) object;
			System.out.println(""+p.getNome());
			System.out.println("iterando");
		}
		System.out.println("fim");
	}
}

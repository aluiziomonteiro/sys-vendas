package categoria;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * TestaAlteraCategoria.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaAlteraCategoria {

	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		categoria.setNome("Unhas");
		categoria.setId(1);
		CategoriaDao dao = new CategoriaDao();
		dao.adicionaAltera(categoria);
		System.out.println("Categoria alterada com sucesso");

	}

}

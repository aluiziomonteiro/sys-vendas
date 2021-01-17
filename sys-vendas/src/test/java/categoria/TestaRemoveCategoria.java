package categoria;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * TestaRemoveCategoria.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaRemoveCategoria {

	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		CategoriaDao dao = new CategoriaDao();
		dao.remover(categoria);
		System.out.println("Categoria removida com sucesso");

	}

}

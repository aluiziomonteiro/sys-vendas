package categoria;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * TestaInsereCategoria.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaInsereCategoria {

	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		categoria.setNome("M�os");
		
		CategoriaDao dao = new CategoriaDao();
		dao.adicionar(categoria);
		System.out.println("Categoria adicionada com sucesso.");
		
	}
}

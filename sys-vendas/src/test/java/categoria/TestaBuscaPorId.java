package categoria;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;
import br.com.aluizio.sysvendas.model.Produto;


public class TestaBuscaPorId {

	public static void main(String[] args) {
		Produto produto = new Produto();
		
		produto.setId(20);
		Categoria categoria = (Categoria) new CategoriaDao().buscaPorId(produto);
		
		System.out.println(categoria);

	}

}

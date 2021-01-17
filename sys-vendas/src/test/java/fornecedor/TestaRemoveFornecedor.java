package fornecedor;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * TestaRemoveFornecedor.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaRemoveFornecedor {

	public static void main(String[] args)  {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(2);
		
		FornecedorDao dao = new FornecedorDao();
		dao.remover(fornecedor);
		System.out.println("Fornecedor removido com sucesso");

	}

}

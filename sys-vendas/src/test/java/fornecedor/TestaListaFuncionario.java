package fornecedor;

import java.util.List;

import br.com.aluizio.sysvendas.dao.FornecedorDao;

/**
 * TestaListaFuncionario.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaListaFuncionario {

	public static void main(String[] args) {
		FornecedorDao dao = new FornecedorDao();
		List<Object> fornecedores = dao.getList();
		
		for (Object fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	
		System.out.println("Fornecedor listados com sucesso");

	}
}

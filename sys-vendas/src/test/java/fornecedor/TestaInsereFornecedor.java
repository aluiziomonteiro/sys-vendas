package fornecedor;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * TestaInsereFornecedor.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaInsereFornecedor {

	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setPessoa(EnumPessoa.JURIDICA);
		fornecedor.setNome("Hinode");
		fornecedor.setCnpjCpf("091239898232198");
		fornecedor.setCep("73350-101");
		fornecedor.setEndereco("Vila Buritís Q.1 ");
		fornecedor.setBairro("Octogonal");
		fornecedor.setCidade("Goianésia");
		fornecedor.setComplemento("SCL");
		fornecedor.setUf("AL");
		fornecedor.setFone("41-12123434");
		fornecedor.setEmail("hinode@hino.com.br");
		fornecedor.setObservacao("Endereço fictício");
		
		FornecedorDao dao = new FornecedorDao();
		dao.adicionaAltera(fornecedor);
		System.out.println("Fornecedor adicionado com sucesso");

	}

}

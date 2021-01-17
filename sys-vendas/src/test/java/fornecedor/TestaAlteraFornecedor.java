package fornecedor;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * TestaAlteraFornecedor.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaAlteraFornecedor {

	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setPessoa(EnumPessoa.JURIDICA);
		fornecedor.setNome("Golden Bird ");
		fornecedor.setCnpjCpf("982309123982198");
		fornecedor.setCep("73350-101");
		fornecedor.setEndereco("Av. Eldorado ");
		fornecedor.setBairro("Octogonow");
		fornecedor.setCidade("Goianésia");
		fornecedor.setComplemento("SCL");
		fornecedor.setUf("AL");
		fornecedor.setFone("41-12123434");
		fornecedor.setEmail("hinode@hino.com.br");
		fornecedor.setObservacao("Dados Fictício");
		
		fornecedor.setId(9);
		
		FornecedorDao dao = new FornecedorDao();
		dao.adicionaAltera(fornecedor);
		System.out.println("Fornecedor atualizado com sucesso");

	}

}

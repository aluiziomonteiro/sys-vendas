package cliente;

import java.time.LocalDate;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;

/**
 * TestaInsereCliente.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaInsereCliente {

	public static void main(String[] args) {
			
		Cliente cliente = new Cliente();
		
		cliente.setSituacao(EnumSituacao.ATIVO);
		cliente.setPessoa(EnumPessoa.FISICA);
		cliente.setSexo(EnumSexo.M);
		cliente.setNome("Aluizio");
		cliente.setSobreNome("Monteiro");
		
		LocalDate nascimento = LocalDate.of(2000, 11, 11);
		cliente.setNascimento(nascimento);
		
		cliente.setEmail("insejunior@gemail.com");
		cliente.setCelular("61-99349-5309");	

		cliente.setEndereco("Rua do Batizado");
		cliente.setBairro("Novo");
		cliente.setCidade("Ortolãndia");
		cliente.setComplemento("123");
		cliente.setNumero("12123");
		cliente.setUf("df");
		cliente.setCep("123121233");
		cliente.setFone("22 322322");
		cliente.setObservacao("Endereço de casa");
		
		ClienteDao dao = new ClienteDao();
		dao.adicionaAltera(cliente);
		
		System.out.println("Cliente cadastrado com sucesso.");
	}

}

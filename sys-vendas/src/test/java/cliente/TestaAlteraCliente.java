package cliente;

import java.time.LocalDate;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;

/**
 * TestaAlteraCliente.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaAlteraCliente {

	public static void main(String[] args) {
			
		Cliente cliente = new Cliente();
		
		cliente.setSituacao(EnumSituacao.ATIVO);
		cliente.setPessoa(EnumPessoa.FISICA);
		cliente.setSexo(EnumSexo.M);
		cliente.setNome("Silvia");
		cliente.setSobreNome("Carla");
		
		LocalDate nascimento = LocalDate.of(1990, 12, 30);
		cliente.setNascimento(nascimento);
		
		cliente.setEmail("Silvia@gemail.com");
		cliente.setCelular("61-99349-5309");	

		cliente.setEndereco("Rua do Batizado");
		cliente.setBairro("Novo");
		cliente.setCidade("Ortol�ndia");
		cliente.setComplemento("123");
		cliente.setNumero("12123");
		cliente.setUf("df");
		cliente.setCep("123121233");
		cliente.setFone("22 322322");
		cliente.setObservacao("Endere�o de casa");
		
		cliente.setId(24);
		
		ClienteDao dao = new ClienteDao();
		dao.alterar(cliente);
		
		System.out.println("Cliente Alterado com sucesso.");
	}

}

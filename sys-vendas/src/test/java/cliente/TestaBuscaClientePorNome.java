package cliente;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * TestaBuscaPorNome.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class TestaBuscaClientePorNome {

	public static void main(String[] args) {
		Cliente clienteBuscado = new Cliente();
		clienteBuscado.setNome("a");
		
		ClienteDao dao = new ClienteDao();
		List<Object> clientes = dao.buscaPorNome(clienteBuscado);
		
		clientes.forEach(c -> System.out.println(c));
		
		System.out.println("Fim do processo de busca");
	}

}

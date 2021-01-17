package cliente;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * TestaBuscaPorNome.java
 * @author Aluizio Monteiro
 * 21 de set de 2018
 */

public class TestaBuscaClientePorId {

	public static void main(String[] args) {
		//id buscado
		Cliente clienteBuscado = new Cliente();
		clienteBuscado.setId(1);
		
		//cria o dao
		ClienteDao dao = new ClienteDao();
		
		//retorna cliente e respect�vos endere�os
		Cliente cliente = (Cliente) dao.buscaPorId(clienteBuscado);
		
		//Imprime tudo
		System.out.println(cliente);
		
	}
}

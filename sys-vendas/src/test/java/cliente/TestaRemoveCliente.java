package cliente;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * TestaRemoveCliente.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class TestaRemoveCliente {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setId(3);
		
		ClienteDao dao = new ClienteDao();
		dao.remover(cliente);
		System.out.println("Cliente removido com sucesso");

	}

}

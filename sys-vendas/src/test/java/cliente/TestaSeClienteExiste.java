package cliente;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * TestaSeClienteExiste.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class TestaSeClienteExiste {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("");
		ClienteDao dao = new ClienteDao();
		dao.existCliente(cliente);
		System.out.println("FIm da verificação");
	}

}

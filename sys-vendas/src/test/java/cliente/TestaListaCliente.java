package cliente;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * TestaListaCliente.java
 * 
 * @author Aluizio Monteiro 22 de ago de 2018
 */

public class TestaListaCliente {

	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();
		Cliente c = new Cliente();
		c.setNome("Aluizio");
		List<Object> clientes = dao.buscaPorNome(c);
		clientes.forEach(cli -> System.out.println(((Cliente) cli).getCelular()));
		System.out.println("Fim da listagem");
	}
}

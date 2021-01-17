package dashboard;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaProdutosReserva.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TestaProdutosReserva {

	public static void main(String[] args) {
		// Produtos Na Reserva
		System.out.println("Produtos");
		ProdutoDao produtoDao = new ProdutoDao();

		System.out.println("* Estão na reserva");
		List<Produto> reservaList = produtoDao.reservaList();
		reservaList.forEach(p -> System.out.println(p));

	}
}

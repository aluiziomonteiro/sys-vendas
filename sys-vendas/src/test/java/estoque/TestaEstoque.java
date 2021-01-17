package estoque;

import br.com.aluizio.sysvendas.dao.EstoqueDao;
import br.com.aluizio.sysvendas.model.Estoque;

public class TestaEstoque {
	public static void main(String[] args) {
		
		
		Estoque estoqueBuscado = new Estoque();
		estoqueBuscado.setId(13);
		
		EstoqueDao dao = new EstoqueDao();
		System.out.println(dao.buscaPorId(estoqueBuscado));
		

		
		
		
	}
}

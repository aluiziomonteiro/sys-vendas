package carrinho;

import java.util.List;

import br.com.aluizio.sysvendas.dao.CarrinhoDao;
import br.com.aluizio.sysvendas.model.Carrinho;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * TestaListaCarrinhoPorOrcamento.java
 * @author Aluizio Monteiro
 * 11 de mar de 2019
 */

public class TestaListaCarrinhoPorOrcamento {

	public static void main(String[] args) {
		CarrinhoDao dao = new CarrinhoDao();
		Orcamento orcamento = new Orcamento();
		
		orcamento.setId(19);
		
		List<Carrinho> list = dao.getCarrinhos(orcamento);
		for (Carrinho carrinho : list) {
			System.out.println(carrinho);
		}

	}

}

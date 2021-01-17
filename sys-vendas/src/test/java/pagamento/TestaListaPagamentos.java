package pagamento;

import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaListaPagamentos.java
 * @author Aluizio Monteiro
 * 10 de mar de 2019
 */

public class TestaListaPagamentos {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.setId(54);
		
		PagamentoDao dao = new PagamentoDao();
		
		
		List<Pagamentos> list = dao.buscaPgPorOrcamento(orcamento);
		for (Pagamentos pagamento : list) {
			System.out.println(pagamento);
		}

	}

}

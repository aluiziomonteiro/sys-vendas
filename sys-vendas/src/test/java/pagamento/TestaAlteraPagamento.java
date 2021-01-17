package pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaAlteraPagamento.java
 * @author Aluizio Monteiro 
 * 23 de ago de 2018
 */

public class TestaAlteraPagamento {
	public static void main(String[] args) {

		Pagamentos pagamento = new Pagamentos();
		pagamento.setNumParcela(11);
		pagamento.setValorParcela(new BigDecimal("200.0"));
		pagamento.setParcelaData(LocalDate.now());
		pagamento.setFkOrcamento(15);
		pagamento.setStatus(EnumStatus.QUITADO);
	
		pagamento.setId(4);
		
		PagamentoDao dao = new PagamentoDao();
		dao.alterar(pagamento);
		
		System.out.println("Pagamento atualizado com sucesso");
	}
}

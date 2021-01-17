package pagamento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaPagamento.java
 * @author Aluizio Monteiro 
 * 11 de abr de 2019
 */

public class TestaPagamento {
	public static void main(String[] args) {

		int fkOrcamento = 152;
		int totalParcelas = 6;
		int idPag = 144; //id do pagamento
		
		// criar list de pagamentos
		List<Pagamentos> list = new ArrayList<>();

		for (int i = 1; i <= totalParcelas; i++) {
			String statusText = String.valueOf("QUITADO");
			EnumStatus status = null;

			//Ajusta o checkbox
			if (statusText.equals("on")) {
				status = EnumStatus.valueOf("QUITADO");
			} else {
				status = EnumStatus.valueOf("A_PAGAR");
			}

			if ( idPag >= 149) {
				int id = idPag;
				System.out.println("Efetuando pagamento da parcela com id: " + id);

				Pagamentos pagamentos = new Pagamentos();
				pagamentos.setStatus(status);
				pagamentos.setId(id);
				pagamentos.setFkOrcamento(fkOrcamento);

				list.add(pagamentos);
				idPag++;
			}
		}

		PagamentoDao d = new PagamentoDao();
		Orcamento orcamento = d.pagarParcela(list);
		System.out.println(orcamento);
		JOptionPane.showMessageDialog(null, "Registrado com Sucesso!");
		System.out.println("Pagamento efetuado com sucesso.");
	}
}

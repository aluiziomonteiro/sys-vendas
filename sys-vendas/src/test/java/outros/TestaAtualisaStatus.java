package outros;

import br.com.aluizio.sysvendas.dao.PagamentoDao;

public class TestaAtualisaStatus {

	public static void main(String[] args) {
		PagamentoDao dao = new PagamentoDao();
		dao.verificaPagamentosVencidos();
		System.out.println("Fim do atualisa status do pagamento...");
	}
}

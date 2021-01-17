package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * Servlet implementation class Pagamento
 */
@WebServlet("/pagamento.jsp")
public class Pagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int fkOrcamento = Integer.parseInt(request.getParameter("fkOrcamento"));
		int totalParcelas = Integer.parseInt(request.getParameter("totalParcelas"));
		int parcelasPagas = 0;

		// criar list de pagamentos
		List<Pagamentos> list = new ArrayList<>();

		for (int i = 1; i <= totalParcelas; i++) {
			String statusText = String.valueOf(request.getParameter("checkBoxPagar[" + i + "]"));

			EnumStatus status = null;

			if (statusText.equals("on")) {
				status = EnumStatus.valueOf("QUITADO");
				parcelasPagas++;
			} else {
				status = EnumStatus.valueOf("A_PAGAR");
			}

			int id = Integer.parseInt(request.getParameter("idPagamento[" + i + "]"));
			System.out.println("Efetuando pagamento da parcela com id: " + id);

			Pagamentos pagamentos = new Pagamentos();

			pagamentos.setStatus(status);
			pagamentos.setId(id);
			pagamentos.setFkOrcamento(fkOrcamento);

			list.add(pagamentos);
		}

		//Atualiza parcelas
		Orcamento orc = new Orcamento();
		orc.setParcelasPagas(parcelasPagas);
		orc.setId(fkOrcamento);
		
		OrcamentoDao orcDao = new OrcamentoDao();
		orcDao.atualizaParcelas(orc);
		
		//Registra o pagamento
		PagamentoDao dao = new PagamentoDao();
		Orcamento orcamento = dao.pagarParcela(list);
		request.setAttribute("orcamento", orcamento);

		JOptionPane.showMessageDialog(null, "Registrado com Sucesso!");

		RequestDispatcher rd = request.getRequestDispatcher("/info-orcamentos.jsp");
		rd.forward(request, response);
		System.out.println("Pagamento efetuado com sucesso.");
	}
}

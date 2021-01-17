package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * Obtem a lista de orçamentos e envia para a página "busca-orcamentos.jsp".
 */

@WebServlet("/buscar-orcamento.jsp")
public class BuscaOrcamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Listar ultimos lançamentos realizados
		String filtro = request.getParameter("filtro");
		Cliente cliente = new Cliente();
		cliente.setNome(filtro);

		OrcamentoDao dao = new OrcamentoDao();
		List<Orcamento> orcamentos = dao.buscaOrcamentoPorCliente(cliente);
		
		for (Orcamento orcamento : orcamentos) {
			System.out.println(orcamento);
		}
		
		request.setAttribute("orcamentos", orcamentos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/buscar-orcamentos.jsp");
		rd.forward(request, response);
	}
}

package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * Servlet responsável pelas funcionalidades dos botões da página
 * busca-fornecedor.jsp. Recebe os ids dos fornecedores
 */
@WebServlet("/gerenciar-fornecedor.jsp")
public class GerenciaFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina = "";
		Fornecedor fornecedor = new Fornecedor();

		// Alterar Fornecedor
		if (request.getParameter("alterar") != null) {
			System.out.println("Id do fornecedor: " + request.getParameter("alterar"));
			// busca fornecedor pelo id e o coloca na requisição
			int id = Integer.parseInt(request.getParameter("alterar"));
			fornecedor.setId(id);
			Fornecedor fornecedorDao = (Fornecedor) new FornecedorDao().buscaPorId(fornecedor);
			System.out.println("Nome do fornecedor: "+fornecedorDao.getNome());
			request.setAttribute("fornecedor", fornecedorDao);

			// formulário de alteração
			pagina = "/alterar-fornecedores.jsp";
		}

		// Remover Fornecedor
		if (request.getParameter("remover") != null) {
			fornecedor.setId(Integer.parseInt(request.getParameter("remover")));
			new FornecedorDao().remover(fornecedor);
			JOptionPane.showMessageDialog(null,"Fornecedor removido com sucesso!");
			pagina = "/buscar-fornecedor.jsp?filtro=";
		}
		
		//Info Fornecedor
		if (request.getParameter("info") != null) {
			int id = Integer.parseInt(request.getParameter("info"));
			fornecedor.setId(id);	
		
			System.out.println("Id da info do fornecedor é: " + id);
	
			// objeto contendo o id do produto
			Fornecedor fornecedorBuscado = new Fornecedor();
			fornecedorBuscado.setId(id);
			
			// busca produto pelo id e o coloca na requisição
			fornecedor = (Fornecedor) new FornecedorDao().buscaPorId(fornecedorBuscado);
			request.setAttribute("fornecedor", fornecedor);
			
			// página de info
			pagina = "/info-fornecedores.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
}
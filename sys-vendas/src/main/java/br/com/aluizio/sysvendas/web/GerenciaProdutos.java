package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * Servlet responsável pelas funcionalidades dos botões da página
 * busca-produtos.jsp. Recebe os ids dos produtos
 */
@WebServlet("/gerenciar-produto.jsp")
public class GerenciaProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pagina = "";

		// Exibe informações completas sobre o produto
	
		if (request.getParameter("info") != null) {
			int id = Integer.parseInt(request.getParameter("info"));
			System.out.println("Id da info do produto é: " + id);
	
			// objeto contendo o id do produto
			Produto produtoBuscado = new Produto();
			produtoBuscado.setId(id);
			
			// busca produto pelo id e o coloca na requisição
			Produto produto = (Produto) new ProdutoDao().buscaPorId(produtoBuscado);
			request.setAttribute("produto", produto);
			
			// página de info
				
			
			pagina = "/info-produtos.jsp";
		}

		// Altera Produtos
		if (request.getParameter("alterar") != null) {
			int id = Integer.parseInt(request.getParameter("alterar"));

			// objeto contendo o id do produto
			Produto produtoBuscado = new Produto();
			produtoBuscado.setId(id);

			// busca produto pelo id e o coloca na requisição
			Produto produto = (Produto) new ProdutoDao().buscaPorId(produtoBuscado);
			request.setAttribute("produto", produto);

			// formulário de alteração
			pagina = "/alterar-produtos.jsp";
		}

		// remove produto
		if (request.getParameter("remover") != null) {
			int id = Integer.parseInt(request.getParameter("remover"));

			// Objeto contendo o id do Produto a ser removido
			Produto produto = new Produto();
			produto.setId(id);

			// Remove
			new ProdutoDao().remover(produto);

			// Vai para lista de produtos
			pagina = "/buscar-produto.jsp?filtro=";

		}

		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
}

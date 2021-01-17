package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * Filtra a busca pelo nome. 
 * Se o filtro for vazio, retorna a lista completa.
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */
@WebServlet("/buscar-fornecedor.jsp")
public class BuscaFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String filtro = req.getParameter("filtro");
		
		Fornecedor f = new Fornecedor();
		f.setNome(filtro);
		
		FornecedorDao dao = new FornecedorDao();
			
		List<Object> fornecedor = dao.buscaPorNome(f);
		
		req.setAttribute("fornecedor", fornecedor);
		
		RequestDispatcher rd = req.getRequestDispatcher("/buscar-fornecedores.jsp");
		rd.forward(req, resp);
	}
}

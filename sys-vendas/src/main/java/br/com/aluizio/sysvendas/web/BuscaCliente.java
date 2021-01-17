package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * Filtra a busca pelo nome. 
 * Se o filtro for vazio, retorna a lista completa.
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */
@WebServlet("/buscar-cliente.jsp")
public class BuscaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");
		
		Cliente c = new Cliente();
		c.setNome(filtro);
		
		ClienteDao dao = new ClienteDao();
			
		List<Object> clientes = dao.buscaPorNome(c);
		
		request.setAttribute("clientes", clientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/buscar-clientes.jsp");
		rd.forward(request, response);
	}
}

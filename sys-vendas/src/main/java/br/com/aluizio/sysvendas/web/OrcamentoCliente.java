package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * Servlet implementation class OrcamentoCliente
 */
@WebServlet({ "/agregar-cliente.jsp", "/eliminar-cliente.jsp" })
public class OrcamentoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String url;
	HttpSession sessaoCliente;
	Cliente cliente;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		defineOperacao(request, response);
	}

	// Escolhe a operação
	protected void defineOperacao(HttpServletRequest request, HttpServletResponse response) throws IOException {

		url = request.getServletPath();

		if (url.equals("/agregar-cliente.jsp")) {
			adicionarCliente(request, response);
		} else if (url.equals("/eliminar-cliente.jsp")) {
			eliminarCliente(request, response);
		}
	}

	// elimina sessão
	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Eliminiar cliente");
		sessaoCliente = request.getSession(false);
		
		request.getSession().removeAttribute("sessaoCliente");
		//System.out.println("Usuário deslogado");
		//request.getRequestDispatcher("/index.html").forward(request, response);
		
		//sessaoCliente.invalidate();
		response.sendRedirect("orcamentos.jsp");
	}

	// Adiciona na lista
	private void adicionarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sessaoCliente = request.getSession(false);
		cliente = (Cliente) sessaoCliente.getAttribute("sessaoCliente");

		// coloca o cliente na session
		if (cliente == null) {
			cliente = new Cliente();
			sessaoCliente.setAttribute("sessaoCliente", cliente);
		}

		// seta o id no obj cliente
		cliente.setId(Integer.parseInt(request.getParameter("id")));

		System.out.println("int da página orçamento: " + cliente.getId());

		// busca cliente no banco e seta no obj com o mesmo nome
		ClienteDao dao = new ClienteDao();
		cliente = (Cliente) dao.buscaPorId(cliente);

		// envia o cliente para a session
		sessaoCliente.setAttribute("sessaoCliente", cliente);
		response.sendRedirect("orcamentos.jsp");
	}
}

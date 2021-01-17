package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * Servlet responsável pelas funcionalidades dos botões
 * da página busca-clientes.jsp.
 * Recebe os ids dos clientes
 */
@WebServlet("/gerenciar-cliente.jsp")
public class GerenciaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String pOrcamento = request.getParameter("orcamento");
    	String pagina = "";

    	//abre orçamento
    	if( pOrcamento != null) {
    		int id = Integer.parseInt(pOrcamento);
    		System.out.println("Id do orcamento do cliente é: "+ id);
    		
    		pagina = "/orcamento-cliente.jsp";
    	}

    	
    	//Exibe informações completas sobre o cliente
    	String info = request.getParameter("info");
    	if(info != null) {
    		int id = Integer.parseInt(info);
    		System.out.println("Id da info do cliente é: "+ id);
    		
    		//objeto contendo o id do cliente
    		Cliente clienteBuscado = new Cliente();
    		clienteBuscado.setId(id);
    		
    		//busca cliente pelo id e o coloca na requisição
			Cliente cliente = (Cliente) new ClienteDao()
					.buscaPorId(clienteBuscado);
    		
			List<Orcamento> list = (List<Orcamento>) 
					new OrcamentoDao().buscaOrcamentoPorCliente(cliente);
			
			request.setAttribute("list", list);
			request.setAttribute("cliente", cliente);
    		pagina = "/info-clientes.jsp";
    	}

    	//alterar clientes
    	if(request.getParameter("alterar") != null) {
    		int id = Integer.parseInt(request.getParameter("alterar"));
    		
    		//objeto contendo o id do cliente
    		Cliente clienteBuscado = new Cliente();
    		clienteBuscado.setId(id);
    		
    		//busca cliente pelo id e o coloca na requisição
    		
			Cliente cliente = (Cliente) new ClienteDao()
					.buscaPorId(clienteBuscado);
    		
			request.setAttribute("cliente", cliente);
    	
    		//formulário de alteração
    		pagina = "/alterar-clientes.jsp";
    	}
    	
    	//remove cliente
    	if(request.getParameter("remover") != null) {
    		int id = Integer.parseInt(request.getParameter("remover"));
    		
    		//Objeto contendo o id do cliente a ser removido
    		Cliente clienteARemover = new Cliente();
    		clienteARemover.setId(id);
    		
    		//Remove
			new ClienteDao().remover(clienteARemover);
    	
			JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
			//Vai para lista de clientes
    		pagina = "/buscar-cliente.jsp?filtro=";
    	} 
    	
    	RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
}

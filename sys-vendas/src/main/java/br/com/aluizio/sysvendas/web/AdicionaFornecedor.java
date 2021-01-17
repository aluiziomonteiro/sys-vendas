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
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * Servlet implementation class NovoFornecedor
 */
@WebServlet("/adicionar-fornecedor.jsp")
public class AdicionaFornecedor extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		Fornecedor fornecedor = new Fornecedor();
		
		//Enum vs Radio
		EnumPessoa pessoa = EnumPessoa.valueOf(req.getParameter("pessoa"));
		
		//Popula Fornecedor
		fornecedor.setPessoa(pessoa);
		fornecedor.setNome(req.getParameter("nome"));
		fornecedor.setCnpjCpf(req.getParameter("cnpjCpf"));
		fornecedor.setCep(req.getParameter("cep"));
		fornecedor.setEndereco(req.getParameter("endereco"));
		fornecedor.setBairro(req.getParameter("bairro"));
		fornecedor.setCidade(req.getParameter("cidade"));
		fornecedor.setComplemento(req.getParameter("complemeto"));
		fornecedor.setUf(req.getParameter("uf"));
		fornecedor.setFone(req.getParameter("fone"));
		fornecedor.setEmail(req.getParameter("email"));
		fornecedor.setObservacao(req.getParameter("observacao"));
		
		//Salva Fornecedor
		new FornecedorDao().adiciona(fornecedor);
		System.out.println("Fornecedor salvo");
		
		JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
		
		//Carrega a index.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/buscar-fornecedor.jsp?filtro=");
		rd.forward(req, resp);
	
	}
}

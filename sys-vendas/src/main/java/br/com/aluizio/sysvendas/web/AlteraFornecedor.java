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
 * Servlet implementation class AlterarFornecedor
 */

@WebServlet("/alterar-fornecedor.jsp")
public class AlteraFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = "Fornecedor atualizado com sucesso.";

		Fornecedor fornecedor = new Fornecedor();

		// Enum que vem do radio contido no alterar-fornecedor.jsp
		EnumPessoa pessoa = EnumPessoa.valueOf(req.getParameter("pessoa"));

		// Popula Fornecedor
		int id = Integer.parseInt(req.getParameter("fornecedorId"));
		fornecedor.setId(id);
		fornecedor.setPessoa(pessoa);
		fornecedor.setNome(req.getParameter("nome"));
		fornecedor.setCnpjCpf(req.getParameter("cnpjCpf"));
		fornecedor.setCep(req.getParameter("cep"));
		fornecedor.setEndereco(req.getParameter("endereco"));
		fornecedor.setBairro(req.getParameter("bairro"));
		fornecedor.setCidade(req.getParameter("cidade"));
		fornecedor.setComplemento(req.getParameter("complemento"));
		fornecedor.setUf(req.getParameter("uf"));
		fornecedor.setFone(req.getParameter("fone"));
		fornecedor.setEmail(req.getParameter("email"));
		fornecedor.setObservacao(req.getParameter("observacao"));

		// Salva Fornecedor
		new FornecedorDao().alterar(fornecedor);

		JOptionPane.showMessageDialog(null, message);

		RequestDispatcher rd = req.getRequestDispatcher("buscar-fornecedor.jsp?filtro=");
		rd.forward(req, resp);
	}
}

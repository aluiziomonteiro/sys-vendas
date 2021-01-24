package br.com.aluizio.sysvendas.web;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.EstoqueDao;
import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.dao.ProdutoFornecedorDao;
import br.com.aluizio.sysvendas.model.Categoria;
import br.com.aluizio.sysvendas.model.Estoque;
import br.com.aluizio.sysvendas.model.Produto;
import br.com.aluizio.sysvendas.model.ProdutoFornecedor;

/**
 * Servlet implementation class NovoCliente
 * 
 * @author Aluizio Monteiro 27 de ago de 2018
 */
@MultipartConfig(

		fileSizeThreshold = 1024 * 1024, // Limite para cntrole de ram/rom 1MB
		maxFileSize = 1024 * 1024 * 4, // limite de aceita��o 4MB
		maxRequestSize = 1024 * 1024 * 4 // limite da requisi��o 4MB
)

@WebServlet("/alterar-produto.jsp")
public class AlteraProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = "Produto atualizado com sucesso.";

		int produtoId = Integer.parseInt(req.getParameter("produtoId"));
		int categoriaId = Integer.parseInt(req.getParameter("categoriaId"));
		int fornecedorId = Integer.parseInt(req.getParameter("fornecedorId"));
		int estoqueId = Integer.parseInt(req.getParameter("estoqueId"));
		BigDecimal custoUnid = new BigDecimal(req.getParameter("custoUnid"));
		BigDecimal sugestaoVenda = new BigDecimal(req.getParameter("sugestaoVenda"));
		int qtdAdicional = Integer.parseInt(req.getParameter("qtdAdicional"));
		int qtdMinima = Integer.parseInt(req.getParameter("qtdMinima"));

		// imagem separa em uma classe que recebe request e retorna string

		// Path da pasta no computador
		File dir = new File("C:\\Users\\junior\\Desktop\\uploads");
		File arquivo = null;

		// Se o diret�rio n�o existe ele cria
		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		// Itera sobre a part, pega a foto e grava em disco
		for (Part part : req.getParts()) {
			if (this.getFileName(part) != null) {

				// grava o arquivo no disco
				arquivo = new File(dir.getAbsolutePath() + "/" + getFileName(part));
				part.write(arquivo.getAbsolutePath());
			}

		}

		// fim da imagem

		// Popula Categoria
		Categoria categoria = new Categoria();
		categoria.setId(categoriaId);
		categoria.setNome(req.getParameter("categoria"));
		// CategoriaDao categoriaDao = new CategoriaDao();
		// categoriaDao.altera(categoria);

		// Cria este estoque para levar o id a ser buscado
		Estoque estoque = new Estoque();
		estoque.setId(estoqueId);

		// Busca o estoque d banco para ser somado
		Estoque estoqueBuscado = (Estoque) new EstoqueDao().buscaPorId(estoque);

		// Soma valor do input com valor que tem no banco
		qtdAdicional += estoqueBuscado.getQtdEntrada();

		estoque.setQtdEntrada(qtdAdicional);
		estoque.setQtdMinima(qtdMinima);
		EstoqueDao estoqueDao = new EstoqueDao();
		estoqueDao.altera(estoque);

		// seta a imagem
		String caminho = String.valueOf(arquivo);
		caminho = caminho.replace("\\", "\\");

		// Cria produto
		Produto produto = new Produto();
		produto.setId(produtoId);
		produto.setNome(req.getParameter("nome"));
		produto.setDescricao(req.getParameter("descricao"));
		produto.setIndicacao(req.getParameter("indicacao"));
		produto.setVolume(req.getParameter("volume"));
		produto.setCustoUnid(custoUnid);
		produto.setSugestaoVenda(sugestaoVenda);
		produto.setImagem(caminho);

		produto.setCategoria(categoria);
		produto.setEstoque(estoque);

		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.alterar(produto);

		// Atualizar relacionamento
		ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor();
		produtoFornecedor.setIdFornecedor(fornecedorId);
		produtoFornecedor.setIdProduto(produtoId);

		new ProdutoFornecedorDao().alterar(produtoFornecedor);
		JOptionPane.showMessageDialog(null, message);

		RequestDispatcher rd = req.getRequestDispatcher("/buscar-produto.jsp?filtro=");
		rd.forward(req, resp);
	}

	// Método que pega o nome do arquivo
	public String getFileName(Part part) {
		String header = part.getHeader("content-disposition");
		for (String tmp : header.split(";")) {
			if (tmp.trim().startsWith("filename")) {
				return tmp.substring(tmp.indexOf("=") + 2, tmp.length() - 1);
			}
		}
		return null;
	}
}

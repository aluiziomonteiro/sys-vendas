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
		
		fileSizeThreshold = 1024 * 1024, //Limite para cntrole de ram/rom 1MB
		maxFileSize = 1024 * 1024 * 4, // limite de aceitação 4MB
		maxRequestSize = 1024 * 1024 * 4 // limite da requisição 4MB
)

@WebServlet("/adicionar-produto.jsp")
public class AdicionaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = "Produto adicionado com sucesso.";

		// Cria produto
		Produto produto = new Produto();

		//imagem separa em uma classe que recebe request e retorna string

		// Path da pasta no computador
		File dir = new File("C:\\Users\\junior\\Desktop\\uploads");
		File arquivo = null;

		// Se o diretório não existe ele cria
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
		

	//fim da imagem

	    // Id da categria
		int categoriaId = Integer.parseInt(req.getParameter("categoriaId"));

		// Popula Estoque
		Estoque estoque = new Estoque();
		
		estoque.setQtdEntrada( Integer.parseInt(req.getParameter("qtdEntrada")));
		estoque.setQtdMinima(Integer.parseInt(req.getParameter("qtdMinima")));
		
		EstoqueDao estoqueDao = new EstoqueDao();
		estoqueDao.adicionaAltera(estoque);
		
		//Após adicionar o estoque, ele busca o id para poder relacionar
		int idEstoque = new EstoqueDao().buscaMaiorId();
		Estoque e = new Estoque();
		e.setId(idEstoque);
	
	    //Insere a categoria no produto
		Categoria categoria = new Categoria();
		categoria.setId(categoriaId);
		produto.setCategoria(categoria);

		produto.setEstoque(e);
		
		produto.setNome(req.getParameter("nome"));
		produto.setDescricao(req.getParameter("descricao"));
		produto.setIndicacao(req.getParameter("indicacao"));
		produto.setVolume(req.getParameter("volume"));
		
		//Custo Unidade
		String custoUnid = req.getParameter("custoUnid").replace(".", "");
		custoUnid = custoUnid.replace(",", ".");
		System.out.println("Custo unid: "+custoUnid);
		produto.setCustoUnid(new BigDecimal(custoUnid));
		 
		//Sugestão de venda
		String sugestao = req.getParameter("sugestaoVenda");
		System.out.println("Sugestão de venda: "+sugestao);
		produto.setSugestaoVenda(new BigDecimal(sugestao));
		
		//Valor Lucro
		String lucro = req.getParameter("lucro");
		System.out.println("Lucro: "+lucro);
		produto.setLucro(new BigDecimal(lucro));
		
		produto.setPercentual(Double.parseDouble(req.getParameter("percentual")));
		
		//seta a imagem
		String caminho = String.valueOf(arquivo);
		caminho = caminho.replace("\\", "\\");

		//retorna caminho
		produto.setImagem(caminho);
		
		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.adicionaAltera(produto);

		//Pega id da listbox fornecedor
		int idFornecedor = Integer.parseInt(req.getParameter("fornecedorId"));
		
		//Depois do produto adicionado, este método busca o último id
		int idProduto = new ProdutoDao().buscaMaiorId();
		
		//Salva o relacionamento
		ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor();
		produtoFornecedor.setIdFornecedor(idFornecedor);
		produtoFornecedor.setIdProduto(idProduto);
		
		new ProdutoFornecedorDao().relacionar(produtoFornecedor);

		JOptionPane.showMessageDialog(null, message);
		
		RequestDispatcher rd = req.getRequestDispatcher("buscar-produto.jsp?filtro=");
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

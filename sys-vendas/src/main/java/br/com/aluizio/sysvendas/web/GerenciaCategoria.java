package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * Servlet responsável pelas funcionalidades dos botões
 * da página busca-categoria.jsp.
 */
@WebServlet("/gerenciar-categoria.jsp")
public class GerenciaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	Categoria categoriaid = new Categoria();
    	String pagina = "";
    	//Alterar Categoria
    	if(request.getParameter("alterar") != null) {
    		categoriaid.setId(Integer.parseInt(request.getParameter("alterar")));
    		Categoria categoria = (Categoria) new CategoriaDao()
					.buscaPorId(categoriaid);
			System.out.println("Alterando a categoria de id: "+categoriaid);
			request.setAttribute("categoria", categoria);
    		pagina = "alterar-categorias.jsp";
    	}
    	
    	//Remove Categoria
    	if(request.getParameter("remover") != null) {
    		categoriaid.setId(Integer.parseInt(request.getParameter("remover")));
			new CategoriaDao().remover(categoriaid);
			JOptionPane.showMessageDialog(null, "Registro removido com sucesso!");
			System.out.println("Removendo a categoria de id: "+categoriaid);
    		pagina = "buscar-categoria.jsp?filtro=";
    	} 
    	
    	RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
}

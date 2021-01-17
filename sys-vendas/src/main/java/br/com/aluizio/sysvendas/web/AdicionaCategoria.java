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
 * Servlet invocada por adicionar-categorias.jsp
 * 
 */

@WebServlet("/adicionar-categoria.jsp")
public class AdicionaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Categoria categoria = new Categoria();
		categoria.setNome(req.getParameter("nome"));
		
		new CategoriaDao().adicionar(categoria);

		JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso.");

		RequestDispatcher rd = req.getRequestDispatcher("/buscar-categoria.jsp?filtro=");
		rd.forward(req, resp);
	}
}
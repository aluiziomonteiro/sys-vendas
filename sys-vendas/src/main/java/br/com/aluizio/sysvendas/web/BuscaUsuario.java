package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Filtra a busca pelo nome. 
 * Se o filtro for vazio, retorna a lista completa.
 * @author Aluizio Monteiro
 * 26 de set de 2018
 */
@WebServlet("/buscar-usuario.jsp")
public class BuscaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");
		
		Usuario usuario = new Usuario();
		usuario.setNome(filtro);
		
		UsuarioDao dao = new UsuarioDao();
			
		List<Object> usuarios = dao.buscaPorNome(usuario);
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher rd = request.getRequestDispatcher("/buscar-usuarios.jsp");
		rd.forward(request, response);
	}
}

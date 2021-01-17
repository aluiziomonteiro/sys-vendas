package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Servlet responsável pelas funcionalidades dos botões da página
 * busca-usuarios.jsp. Recebe os ids dos usuários
 */
@WebServlet("/gerenciar-usuario.jsp")
public class GerenciaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina = "";
		Usuario usuario = new Usuario();

		// Exibe informações completas sobre o cliente
		if (request.getParameter("info") != null) {
			int id = Integer.parseInt(request.getParameter("info"));
			System.out.println("Id da info do usuario é: " + id);
	
			// objeto contendo o id do usuario
			Usuario usuarioBuscado = new Usuario();
			usuarioBuscado.setId(id);
			
			// busca produto pelo id e o coloca na requisição
			usuario = (Usuario) new UsuarioDao().buscaPorId(usuarioBuscado);
			
			request.setAttribute("usuario", usuario);
			
			// página de info
			pagina = "/info-usuarios.jsp";
		}

		// Alterar Usuário
		if (request.getParameter("alterar") != null) {
			System.out.println("Id da info do usuario é: " + request.getParameter("alterar"));
			// busca usuário pelo id e o coloca na requisição
			int id = Integer.parseInt(request.getParameter("alterar"));
			usuario.setId(id);
			Usuario usuarioDao = (Usuario) new UsuarioDao().buscaPorId(usuario);
			System.out.println("Nome do usuario: "+usuarioDao.getNome());
			request.setAttribute("usuario", usuarioDao);

			// formulário de alteração
			pagina = "/alterar-usuarios.jsp";
		}

		// Remover Usuário
		if (request.getParameter("remover") != null) {
			usuario.setId(Integer.parseInt(request.getParameter("remover")));
			new UsuarioDao().remover(usuario);

			pagina = "/index.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
}

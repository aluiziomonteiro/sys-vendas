package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;
import br.com.aluizio.sysvendas.service.CarregarDashboard;

/**
 * Servlet implementation class Login
 * 
 * @author Aluizio Monteiro 29 de ago de 2018
 */
@WebServlet("/login")
public class Login extends CarregarDashboard {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuarioBuscado = new Usuario();
		usuarioBuscado.setLogin(request.getParameter("login"));
		usuarioBuscado.setSenha(request.getParameter("senha"));

		Usuario usuario = new UsuarioDao().buscaUsuario(usuarioBuscado);
		System.out.println(usuario);

		if (usuario.getId() == null) {
			System.out.println("Erro ao tentar se logar.");

			JOptionPane.showMessageDialog(null, "Nome ou senha incorretas.");

			request.getRequestDispatcher("index.html").forward(request, response);
		} else {

			System.out.println("Usuário " + usuario.getNome() + " efetuou login.");

			// Coloca a sessão na memória do servidor e retorna um cookie.
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			request.setAttribute("usuario", usuario.getNome());

			CarregarDashboard.carregarDashboard(request, response);

		}
	}
}

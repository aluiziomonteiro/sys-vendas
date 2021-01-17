package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;
import br.com.aluizio.sysvendas.service.CarregarDashboard;

/**
 * Servlet implementation class AdicionaAlteraUsuario
 * @author Aluizio Monteiro
 * 29 de ago de 2018
 */

@WebServlet({"/adicionar-usuario.jsp", "/alterar-usuario.jsp"})
public class AdicionaAlteraUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String message = "";

		Usuario usuario = new Usuario();

		// Verifica se adiciona ou atualiza
		if (req.getParameter("usuarioId") != null) {// atualiza
			int id = Integer.parseInt(req.getParameter("usuarioId"));
			usuario.setId(id);
			message = "Usuário atualizado com sucesso.";
			
		} else {
			message = "Usuário adicionado com sucesso.";
		}
		
		usuario.setNome(req.getParameter("nome"));
		usuario.setLogin(req.getParameter("login"));
		usuario.setSenha(req.getParameter("senha"));
	
		new UsuarioDao().adicionaAltera(usuario);
		
		JOptionPane.showMessageDialog(null,  message);
		
		//Carrega a index.jsp
		CarregarDashboard.carregarDashboard(req, resp);
		
	}
}

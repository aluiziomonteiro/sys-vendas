package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Deslogar em 10 minutos
		request.getSession().setMaxInactiveInterval(1 * 30);
		
		request.getSession().removeAttribute("usuarioLogado");
		
		request.getSession().removeAttribute("carroCompras");
		request.getSession().removeAttribute("sessaoCliente");
		request.getSession().removeAttribute("total");
		request.getRequestDispatcher("/index.html").forward(request, response);
		System.out.println("Usuário deslogado");
	}
}

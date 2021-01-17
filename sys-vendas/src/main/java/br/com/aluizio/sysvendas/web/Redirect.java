package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ToDo
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */
@WebServlet("/redirect")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tarefa = request.getParameter("tarefa");

		if (tarefa == null) {
			throw new IllegalArgumentException("Não identificou uma página");

		}

		tarefa = "br.com.aluizio.sysvendas.web." + tarefa;

		try {
			Class<?> tipo = Class.forName(tarefa);
			Tarefa instance = (Tarefa) tipo.newInstance();
			String pagina = instance.executa(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(pagina);
			rd.forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new ServletException(e);
		
		}

		

	}
}

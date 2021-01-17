package br.com.aluizio.sysvendas.web;

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Cookies
 * @author Aluizio Monteiro
 * 30 de ago de 2018
 */

public class Cookies{
	
	private final Cookie[] cookies;
	
	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
		System.out.println("Cookies.java diz: Este modelo está vulnerável."
				+ " [document.cookie = \"usuario.logado = presidente\"]");
	}

	//Verifica se o usuário está logado
	public Cookie buscaUsuarioLogado() {
		if (cookies == null) return null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado")) {
				return cookie;
			}
		}
		return null;
	}
	
}

package br.com.aluizio.sysvendas.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarefa.java
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */

public interface Tarefa {

	String executa(HttpServletRequest request, HttpServletResponse response);

}

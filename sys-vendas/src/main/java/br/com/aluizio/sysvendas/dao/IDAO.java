package br.com.aluizio.sysvendas.dao;

import java.util.List;

/**
 * IDAO.java
 */

public interface IDAO {
	void adicionaAltera(Object object);
	void altera(Object object);
	void adiciona(Object object);
	void remover(Object object);
	Object buscaPorId(Object object);
	List<Object> getList();
	List<Object> buscaPorNome(Object object);
}

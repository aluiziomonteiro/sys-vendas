package br.com.aluizio.sysvendas.dao;

import java.util.List;

/**
 * IDAO.java
 */

public interface IDAO {
	void alterar(Object object);

	void adicionar(Object object);

	void remover(Object object);

	Object buscaPorId(Object object);

	List<Object> getList();

	List<Object> buscaPorNome(Object object);
}

package orcamento;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TesteCalculaInvestimento.java
 * @author Aluizio Monteiro
 * 7 de mai de 2019
 */

public class TestaCalculaInvestimento {

	public static void main(String[] args) {
		BigDecimal totalInvestido = new BigDecimal("00.00");
		ProdutoDao produtoDao = new ProdutoDao();
		List<Object> list = produtoDao.getList();
		for (Object object : list) {
			Produto produto = (Produto) object;
			totalInvestido = totalInvestido.add(produto.getCustoUnid());

		}
		System.out.println(totalInvestido);
	}

}

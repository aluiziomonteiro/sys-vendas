package carrinho;

import java.math.BigDecimal;

import br.com.aluizio.sysvendas.dao.CarrinhoDao;

/**
 * TestaLucroLiquido.java
 * @author Aluizio Monteiro
 * 25 de mai de 2019
 */

public class TestaLucroLiquido {

	public static void main(String[] args) {
		CarrinhoDao dao = new CarrinhoDao();
		BigDecimal lucroLiquido = dao.getLucroLiquido();
		System.out.println(lucroLiquido);
		

	}

}

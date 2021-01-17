package carrinho;

import java.math.BigDecimal;

import br.com.aluizio.sysvendas.dao.CarrinhoDao;

/**
 * TestaLucroLiquido.java
 * @author Aluizio Monteiro
 * 25 de mai de 2019
 */

public class TestaLucroBruto {

	public static void main(String[] args) {
		CarrinhoDao dao = new CarrinhoDao();
		BigDecimal lucroBruto = dao.getLucroBruto();
		System.out.println(lucroBruto);
	}
}

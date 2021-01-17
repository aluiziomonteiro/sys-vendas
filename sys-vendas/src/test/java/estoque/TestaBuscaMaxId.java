package estoque;

import br.com.aluizio.sysvendas.dao.EstoqueDao;

/**
 * TestaBuscaMaxId.java
 * 
 * @author Aluizio Monteiro 27 de ago de 2018
 */

public class TestaBuscaMaxId {
	public static void main(String[] args) {
		
		System.out.println(new EstoqueDao().buscaMaiorId());
	}
}

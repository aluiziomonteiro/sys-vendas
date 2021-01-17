package outros;

import java.math.BigDecimal;

/**
 * TestBigDecimal.java
 * @author Aluizio Monteiro
 * 5 de out de 2018
 */

public class TestBigDecimal {

	public static void main(String[] args) {
		BigDecimal big1 = new BigDecimal("10.00");
        BigDecimal big2 = new BigDecimal("0.6");
        BigDecimal bigResult = big1.multiply(big2);
        
        System.out.println(bigResult.multiply(new BigDecimal("0.01")));   
	}
}

package outros;

/**
 * TesteArray.java
 * @author Aluizio Monteiro
 * 30 de abr de 2019
 */

public class TesteArray {

	public static void main(String[] args) {
		int[] meuArray = new int[12];
		meuArray[0] = 10;
		meuArray[1] = 100;
		meuArray[2] = 200;
		meuArray[3] = 300;
		meuArray[4] = 400;
		meuArray[5] = 10;
		meuArray[6] = 100;
		meuArray[7] = 200;
		meuArray[8] = 300;
		meuArray[9] = 400;
		meuArray[10] = 100;
		meuArray[11] = 200;
		
		int m[] = meuArray;
		
		for (int i = 0; m.length < 12; i++) {
			System.out.println("Elemento: "+m[i]);
		}
		

	}

}

package outros;

import java.time.LocalDate;

public class TesteDataModel {
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		String amanhaText = "2018-11-28";
		
		LocalDate amanha = LocalDate.parse(amanhaText);
		
		System.out.println("Hoje: " + hoje);
		System.out.println("Amanh� ser�: "+amanha);
		
		if(hoje.equals(amanha)) {
			System.out.println("S�o Iguais");
		}else {
			System.out.println("S�o Diferentes");
		}

	}
}

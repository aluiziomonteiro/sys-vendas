package outros;

import java.time.LocalDate;

public class TesteDataModel {
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		String amanhaText = "2018-11-28";
		
		LocalDate amanha = LocalDate.parse(amanhaText);
		
		System.out.println("Hoje: " + hoje);
		System.out.println("Amanhã será: "+amanha);
		
		if(hoje.equals(amanha)) {
			System.out.println("São Iguais");
		}else {
			System.out.println("São Diferentes");
		}

	}
}

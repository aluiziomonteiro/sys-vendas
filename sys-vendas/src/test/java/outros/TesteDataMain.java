package outros;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * TesteDataMain.java
 * @author Aluizio Monteiro
 * 26 de nov de 2018
 */

public class TesteDataMain {

	public static void main(String[] args) {
		//Data de agora
		LocalDate agora = LocalDate.now();
		System.out.println("Hoje é: "+ agora);
		
		//Setando valores
		LocalDate virada = LocalDate.of(2018, Month.DECEMBER, 31);
		System.out.println("A virada é: "+ virada);
		
		LocalDate posse = LocalDate.of(2018, 12, 31);
		System.out.println("A posse é: "+ posse);
		
		//Fazendo cálculos
		int diasQueFaltam = virada.getDayOfYear() - agora.getDayOfYear();
		System.out.println("Faltam "+diasQueFaltam +" dias para a virada.");
		
	
		//Saída formatada do period
		Period diferenca = Period.between(agora, posse);
		System.out.println("Faltam " 
		+diferenca.getDays()+" dias, "
		+diferenca.getMonths()+" meses e "
		+diferenca.getYears()+" anos.");
		
		//Saída formatada do LocalDate 2
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate proximaEleicoes = agora.plusYears(4);
		
		System.out.println("diferença sem formatar localdate : "+proximaEleicoes);
		System.out.println("diferença formatada localdate : "+proximaEleicoes.format(fmt));
		String s = proximaEleicoes.format(fmt);
		System.out.println("diferença formatar em String : "+s);
		
		//Somando dias, meses e anos
		System.out.println("Agora + 2 dias: "+agora.plusDays(2));
		System.out.println("Agora + 3 meses: "+agora.plusMonths(3));
		System.out.println("Agora + 5 anos: "+agora.plusYears(5));
		
		
		
		
		
	}
}

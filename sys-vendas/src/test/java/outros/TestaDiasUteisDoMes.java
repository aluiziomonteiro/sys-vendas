package outros;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TestaSequenciaData.java
 * @author Aluizio Monteiro
 * 26 de abr de 2019
 */

public class TestaDiasUteisDoMes {

	public static void main(String[] args) {
		LocalDate data = LocalDate.now();
		int ano = data.getYear();
		int mes = data.getMonth().getValue();
		int mesFinal = data.getMonth().minus(6).getValue();
				
		
		YearMonth anoMesInicial = YearMonth.of(ano, mes);
		YearMonth anoMesFinal = YearMonth.of(ano, mesFinal);
		List<LocalDate> ListaMeses =  
				Stream.iterate(anoMesFinal.atDay(1), elemento -> elemento.minusMonths(1))
		.limit(anoMesInicial.lengthOfMonth())
				.filter(elemento -> !data.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !data.getDayOfWeek().equals(DayOfWeek.SATURDAY)).collect(Collectors.toList());
	
		ListaMeses.forEach(e->System.out.println(e));
		
	}

}	

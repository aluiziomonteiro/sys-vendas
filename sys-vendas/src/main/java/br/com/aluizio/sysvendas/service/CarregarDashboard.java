package br.com.aluizio.sysvendas.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Dividas;
import br.com.aluizio.sysvendas.model.Investimentos;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamentos;
import br.com.aluizio.sysvendas.model.Produto;
import br.com.aluizio.sysvendas.model.Vendas;

/**
 * CarregarDashboard.java
 * @author Aluizio Monteiro
 * 27 de mai de 2019
 */

public abstract class CarregarDashboard extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public static void carregarDashboard(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
			
		//Verifica parcelas com data vencida
		PagamentoDao dao = new PagamentoDao();
		dao.verificaPagamentosVencidos();
		
		// Carrega dashboard
	
		// Lista a receber
		List<Pagamentos> listaAReceber = AReceber.getListaValoresAReceber();
		request.setAttribute("listaAReceber", listaAReceber);//
	
		// Total a receber
		System.out.println("- Total atrasados");
		BigDecimal valorTotalAtraso = AReceber.getValorTotalAtraso(listaAReceber);
		request.setAttribute("valorTotalAtraso", valorTotalAtraso);
	
		// Lista A Receber Hoje
		List<Pagamentos> listaAReceberHoje = AReceberHoje.getListAReceberHoje();
		listaAReceberHoje.forEach(e -> System.out.println(e));
		request.setAttribute("listaAReceberHoje", listaAReceberHoje);//
	
		// Valor A Receber Hoje
		BigDecimal valorAReceberHoje = AReceberHoje.getValorAReceberHoje(listaAReceberHoje);
		System.out.println("- Valor a receber hoje: " + valorAReceberHoje);
		request.setAttribute("valorAReceberHoje", valorAReceberHoje);
	
		// Lista á receber mês
		List<Pagamentos> listaAReceberMes = AReceberMes.getListAReceberMes();
		request.setAttribute("listaAReceberMes", listaAReceberMes);//
	
		// Valor total a receber mês
		BigDecimal valorAReceberMes = AReceberMes.getValorAReceberMes(listaAReceberMes);
		request.setAttribute("valorAReceberMes", valorAReceberMes);
	
		// Lista á receber Semana
		List<Pagamentos> listaAReceberSemana = AReceberSemana.getListaAReceberSemana();//
		request.setAttribute("listaAReceberSemana", listaAReceberSemana);
	
		// Valor á receber Semana
		BigDecimal valorAReceberSemana = AReceberSemana.getValorAReceberSemana(listaAReceberSemana);
		request.setAttribute("valorAReceberSemana", valorAReceberSemana);
	
		// Produtos Esgotado
		List<Produto> produtosEsgotados = ProdutosEsgotados.getProdutosEsgotados();
		request.setAttribute("produtosEsgotados", produtosEsgotados);
	
		// Lista de produtos na reserva
		List<Produto> produtosReserva = ProdutosReserva.getProdutosReserva();
		request.setAttribute("produtosReserva", produtosReserva);
	
		// Produtos Top List
		List<Produto> produtoTopList = ProdutoTopList.getProdutoTopList();
		request.setAttribute("produtoTopList", produtoTopList);
	
		// Lista de pagamentos em Atraso
		List<Pagamentos> listaAtrasos = TotalAtraso.getListaAtraso();
		request.setAttribute("listaAtrasos", listaAtrasos);
	
		// Valor total Atraso
		BigDecimal totalAtraso = TotalAtraso.getTotalAtraso(listaAtrasos);
		request.setAttribute("totalAtraso", totalAtraso);
	
		// Listar todas as dívidas em_atraso e a_pagar
		List<Pagamentos> listaDividas = TotalDividas.getDividas();
		request.setAttribute("listaDividas", listaDividas);
	
		// Valor total dívidas
		BigDecimal totalDividas = TotalDividas.getListDividas(listaDividas);
		request.setAttribute("totalDividas", totalDividas);
	
		// Total Investido
		BigDecimal totalInvestido = VisaoGeral.getTotalInvestido();
		request.setAttribute("totalInvestido", totalInvestido);
	
		// LucroLiquido
		BigDecimal lucroLiquido = VisaoGeral.getLucroLiquido();
		request.setAttribute("lucroLiquido", lucroLiquido);
	
		// LucroBruto
		BigDecimal lucroBruto = VisaoGeral.getLucroBruto();
		request.setAttribute("lucroBruto", lucroBruto);
	
		// Extimativa Bruta
		BigDecimal extimativaBruta = VisaoGeral.getExtimativaBruta();
		request.setAttribute("extimativaBruta", extimativaBruta);
	
		// Extimativa Liquida
		BigDecimal extimativaLiquida = VisaoGeral.getExtimativaLiquida();
		request.setAttribute("extimativaLiquida", extimativaLiquida);
	
		// Vendas Ordenadas por Mes
		List<Vendas> vendasMes = VendasMes.buscaVendasMes();
		request.setAttribute("vendasMes", vendasMes);
	
		//investimento das vendas por mês
		List<Investimentos> investimentosMes = InvestimentosMes.buscaInvestimentosMes();
		request.setAttribute("investimentosMes", investimentosMes);
		
		// Vendas Ordenadas por Ano
		List<Vendas> vendasAno = VendasAno.buscaVendasAno();
		request.setAttribute("vendasAno", vendasAno);
	
		// Listar todas as dívidas em_atraso 
		List<Dividas> dividasAtrasadas = TotalDividas.getDividasAtrasadas();
		request.setAttribute("dividasAtrasadas", dividasAtrasadas);
		
		// Listar todas as dívidas a receber
		List<Dividas> dividasAReceber = TotalDividas.getDividasAReceber();
		request.setAttribute("dividasAReceber", dividasAReceber);
		
		// Listar ultimos lançamentos realizados
		List<Orcamento> orcamentos = UltimosOrcamentos.ultimosLancamentos();
		request.setAttribute("orcamentos", orcamentos);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
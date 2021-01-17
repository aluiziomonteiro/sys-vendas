package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;

import br.com.aluizio.sysvendas.dao.CarrinhoDao;
import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.dao.ProdutoDao;

/**
 * VisaoGeral.java
 * 
 * @author Aluizio Monteiro 25 de abr de 2019
 */

public class VisaoGeral {

	/**
	 * Extimativa de Lucro Bruto
	 * 
	 * @return BigDecimal extimativaBruta
	 */
	public static BigDecimal getExtimativaBruta() {
		System.out.println("Extimativa de Lucro");
		BigDecimal extimativaBruta = new BigDecimal("0.00");
		extimativaBruta = new PagamentoDao().buscaLucroBruto();
		return extimativaBruta;

	}

	/**
	 * Extimativa de Lucro Liquida
	 * 
	 * @return BigDecimal extimativaLiquida
	 */
	public static BigDecimal getExtimativaLiquida() {
		BigDecimal extimativaLiquida = new BigDecimal("0.00");
		extimativaLiquida = new PagamentoDao().buscaLucroLiquido();
		System.out.println("Busca extimativas: "+extimativaLiquida);
		return extimativaLiquida;
		
	}

	/**
	 * Total Lucro Bruto Vendido
	 * 
	 * @return BigDecimal totalVendas
	 */
	public static BigDecimal getLucroBruto() { 
		BigDecimal lucroBruto = new BigDecimal("0.00");
		lucroBruto = new CarrinhoDao().getLucroBruto();
		return lucroBruto;
	}

	/**
	 * Total Lucro Liquido Vendido
	 * 
	 * @return BigDecimal totalVendas - totalInvestido
	 */
	public static BigDecimal getLucroLiquido() {
		BigDecimal lucroLiquido = new BigDecimal("0.00"); 
		lucroLiquido = new CarrinhoDao().getLucroLiquido();
		return lucroLiquido;
	}

	/**
	 * Total Investido
	 * 
	 * @return BigDecimal totalInvestido
	 */
	
	public static BigDecimal getTotalInvestido() {
		ProdutoDao produtoDao = new ProdutoDao();
		BigDecimal totalInvestido = new BigDecimal("0.00");
		totalInvestido = (BigDecimal) produtoDao.getTotalInvestido();
		
		System.out.println("Visão Geral- Get Total Investido");
		return totalInvestido;
	}

}

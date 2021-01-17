package br.com.aluizio.sysvendas.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Carrinho;
import br.com.aluizio.sysvendas.model.Investimentos;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * CarrinhoDao.java
 * 
 * @author Aluizio Monteiro 11 de mar de 2019
 */

public class CarrinhoDao {
	private Connection connection;

	public CarrinhoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Lista de carrinho
	public List<Carrinho> getCarrinhos(Orcamento orcamento) {

		String sql = "select * from carrinho where fk_orcamento = " + orcamento.getId();
		List<Carrinho> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Carrinho carrinho = new Carrinho();
				carrinho.setProdutoId(rs.getInt("produtoId"));
				carrinho.setOrcamentoId(rs.getInt("fk_orcamento"));
				carrinho.setProdutoNome(rs.getString("produtoNome"));
				carrinho.setQtd(rs.getInt("qtd"));
				carrinho.setSubTotal(rs.getBigDecimal("subTotal"));
				carrinho.setValorUnid(rs.getBigDecimal("valorUnid"));
				carrinho.setCusto(rs.getBigDecimal("custo"));
				carrinho.setData(rs.getDate("data").toLocalDate());
				list.add(carrinho);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	//Valor total do lucro
	public BigDecimal getLucroLiquido() {
		String sql = "select (sum(subTotal) - sum(custo)) as lucros from carrinho";

		BigDecimal valor = new BigDecimal("0.00");

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				valor = rs.getBigDecimal("lucros");
			}
			
			if (valor == null) {
				valor = new BigDecimal("0.00");
			}
			return valor;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//Valor total do lucro
		public BigDecimal getLucroBruto() {
			String sql = "select sum(subTotal) as lucros from carrinho";

			BigDecimal valor = new BigDecimal("0.00");

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					valor = rs.getBigDecimal("lucros"); 
				}
				
				if (valor == null) {
					System.out.println("Valor carrinhodao "+valor);
					valor = new BigDecimal("0.00");
				}
				
				return valor;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	//Custo de produtos vendidos em um determinado mês
		public List<Investimentos> getInvestimentosMes() {
			String sql = "select sum(custo) as custos, data from carrinho group by month(data) order by data limit 12";

			List<Investimentos> list = new ArrayList<>();

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Investimentos investimentosMes = new Investimentos();

					LocalDate data = rs.getDate("data").toLocalDate();

					investimentosMes.setMes(data.getMonth().getValue());
					investimentosMes.setAno(data.getYear());
					investimentosMes.setValorTotal(rs.getBigDecimal("custos"));

					list.add(investimentosMes);
				}
				return list;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}

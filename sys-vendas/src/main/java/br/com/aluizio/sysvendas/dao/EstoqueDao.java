package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Estoque;

public class EstoqueDao {

	Connection connection;

	public EstoqueDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Busca Estoque por Id
	public Object buscaPorId(Object object) {
		Estoque estoqueBuscado = (Estoque) object;
		String sql = "select * from estoques " + " where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, estoqueBuscado.getId());
			ResultSet rs = stmt.executeQuery();
			Estoque estoque = new Estoque();
			while (rs.next()) {
				estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
				estoque.setQtdSaida(rs.getInt("qtdSaida"));
				estoque.setQtdMinima(rs.getInt("qtdMinima"));
				estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));
				estoque.setId(rs.getInt("id"));
			}
			return estoque;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Adiciona e Altera
	public void adicionaAltera(Object object) {
		String sql = "";
		Estoque estoque = (Estoque) object;
		if (estoque.getId() == null) {
			sql = "Insert Into estoques (qtdEntrada, qtdMinima)" + " values (?,?)";
		} else {
			sql = "Update estoques set qtdEntrada=?, qtdMinima=?" + " where id=?";
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, estoque.getQtdEntrada());
			stmt.setInt(2, estoque.getQtdMinima());

			stmt.execute();
			System.out.println("Estoque adicionado com sucesso");
		} catch (SQLException e) {
			System.out.println("Problemas ao adicionar Estoque");
			throw new RuntimeException(e);
		}
	}

	// Altera
	public void altera(Object object) {
		String sql = "";
		Estoque estoque = (Estoque) object;
		sql = "Update estoques set qtdEntrada=?, qtdMinima=?" + " where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, estoque.getQtdEntrada());
			stmt.setInt(2, estoque.getQtdMinima());
			stmt.setInt(3, estoque.getId());

			stmt.execute();
			System.out.println("Estoque adicionado com sucesso");
		} catch (SQLException e) {
			System.out.println("Problemas ao adicionar Estoque");
			throw new RuntimeException(e);
		}
	}

	// Busca Maior Id
	public int buscaMaiorId() {
		String sql = "Select max(id) from estoques";
		int id = 0;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			return id;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

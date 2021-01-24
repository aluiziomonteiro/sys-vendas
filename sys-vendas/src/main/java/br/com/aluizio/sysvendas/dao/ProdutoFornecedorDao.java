package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.ProdutoFornecedor;

/**
 * @author Aluizio Monteiro
 */

public class ProdutoFornecedorDao {
	private Connection connection;

	public ProdutoFornecedorDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Adiciona Fornecedor
	public void relacionar(ProdutoFornecedor produtoFornecedor) {
		String sql = "Insert into produtos_fornecedores " + " (fk_fornecedor, fk_produto) value (?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produtoFornecedor.getIdFornecedor());
			stmt.setInt(2, produtoFornecedor.getIdProduto());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Alterar Fornecedor
	public void alterar(ProdutoFornecedor produtoFornecedor) {
		String sql = "update produtos_fornecedores " + "set fk_fornecedor=? where fk_produto=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produtoFornecedor.getIdFornecedor());
			stmt.setInt(2, produtoFornecedor.getIdProduto());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

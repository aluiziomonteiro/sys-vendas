package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * @author Aluizio Monteiro
 */

public class FornecedorDao implements IDAO {

	Connection connection;

	public FornecedorDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Adicionar Fornecedor
	@Override
	public void adicionar(Object object) {
		String sql = "";
		Fornecedor fornecedor = (Fornecedor) object;
		sql = "Insert into fornecedores (pessoa, nome, " + "cnpjCpf, cep, endereco, bairro, cidade, complemento, "
				+ "uf, fone, email, observacao) " + "values (?,?,?,?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, fornecedor.getPessoa().name());
			stmt.setString(2, fornecedor.getNome());
			stmt.setString(3, fornecedor.getCnpjCpf());
			stmt.setString(4, fornecedor.getCep());
			stmt.setString(5, fornecedor.getEndereco());
			stmt.setString(6, fornecedor.getBairro());
			stmt.setString(7, fornecedor.getCidade());
			stmt.setString(8, fornecedor.getComplemento());
			stmt.setString(9, fornecedor.getUf());
			stmt.setString(10, fornecedor.getFone());
			stmt.setString(11, fornecedor.getEmail());
			stmt.setString(12, fornecedor.getObservacao());

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Alterar Fornecedor

	public void alterar(Object object) {
		String sql = "";
		Fornecedor fornecedor = (Fornecedor) object;
		sql = "Update fornecedores set pessoa=?, nome=?, "
				+ "cnpjCpf=?, cep=?, endereco=?, bairro=?, cidade=?, complemento=?, "
				+ "uf=?, fone=?, email=?, observacao=? where id=" + fornecedor.getId();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, fornecedor.getPessoa().name());
			stmt.setString(2, fornecedor.getNome());
			stmt.setString(3, fornecedor.getCnpjCpf());
			stmt.setString(4, fornecedor.getCep());
			stmt.setString(5, fornecedor.getEndereco());
			stmt.setString(6, fornecedor.getBairro());
			stmt.setString(7, fornecedor.getCidade());
			stmt.setString(8, fornecedor.getComplemento());
			stmt.setString(9, fornecedor.getUf());
			stmt.setString(10, fornecedor.getFone());
			stmt.setString(11, fornecedor.getEmail());
			stmt.setString(12, fornecedor.getObservacao());

			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Remover
	@Override
	public void remover(Object object) {
		Fornecedor fornecedor = (Fornecedor) object;
		String sql = "Delete from fornecedores where id=? ";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, fornecedor.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Listar
	@Override
	public List<Object> getList() {
		String sql = "Select * from fornecedores";
		List<Object> lista = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setPessoa(EnumPessoa.valueOf(rs.getString("pessoa")));
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpjCpf(rs.getString("cnpjCpf"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setCidade(rs.getString("cidade"));
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setUf(rs.getString("uf"));
				fornecedor.setFone(rs.getString("fone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setObservacao(rs.getString("observacao"));

				lista.add(fornecedor);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	// Busca Maior Id
	public int buscaMaiorId() {
		String sql = "Select max(id) from fornecedores";
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

	@Override
	public Object buscaPorId(Object object) {
		Fornecedor f = (Fornecedor) object;
		Fornecedor fornecedor = new Fornecedor();
		String sql = "Select * from fornecedores where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, f.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				fornecedor.setPessoa(EnumPessoa.valueOf(rs.getString("pessoa")));
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpjCpf(rs.getString("cnpjCpf"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setCidade(rs.getString("cidade"));
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setUf(rs.getString("uf"));
				fornecedor.setFone(rs.getString("fone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setObservacao(rs.getString("observacao"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return fornecedor;
	}

	//
	@Override
	public List<Object> buscaPorNome(Object object) {

		Fornecedor f = (Fornecedor) object;
		List<Object> lista = new ArrayList<>();
		if (!existFornecedor(f)) {
			System.out.println("Fornecedor n�o existe.");
		} else {
			String sql = "select * from fornecedores where nome like ?";

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				String termo = "%" + f.getNome() + "%";
				stmt.setString(1, termo);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Fornecedor fornecedor = new Fornecedor();
					fornecedor.setPessoa(EnumPessoa.valueOf(rs.getString("pessoa")));
					fornecedor.setId(rs.getInt("id"));
					fornecedor.setNome(rs.getString("nome"));
					fornecedor.setCnpjCpf(rs.getString("cnpjCpf"));
					fornecedor.setCep(rs.getString("cep"));
					fornecedor.setEndereco(rs.getString("endereco"));
					fornecedor.setBairro(rs.getString("bairro"));
					fornecedor.setCidade(rs.getString("cidade"));
					fornecedor.setComplemento(rs.getString("complemento"));
					fornecedor.setUf(rs.getString("uf"));
					fornecedor.setFone(rs.getString("fone"));
					fornecedor.setEmail(rs.getString("email"));
					fornecedor.setObservacao(rs.getString("observacao"));
					lista.add(fornecedor);
				}

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return lista;
	}

	public boolean existFornecedor(Fornecedor fornecedor) {
		String sql = "select * from fornecedores where nome like ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			String termo = "%" + fornecedor.getNome() + "%";
			stmt.setString(1, termo);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				System.out.println("n�o existe");
				return false;

			} else {
				System.out.println("existe sim");
				return true;

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

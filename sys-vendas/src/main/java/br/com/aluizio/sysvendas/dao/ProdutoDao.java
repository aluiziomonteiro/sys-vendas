package br.com.aluizio.sysvendas.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Categoria;
import br.com.aluizio.sysvendas.model.Estoque;
import br.com.aluizio.sysvendas.model.Fornecedor;
import br.com.aluizio.sysvendas.model.Produto;
/**
 * @author Aluizio Monteiro
 */
public class ProdutoDao {
	Connection connection;

	public ProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Listar Todos Produto
	public List<Object> getList() {
		String sql = "select * from produtos join fornecedores on produtos.fk_fornecedor = fornecedores.id";
		List<Object> produtos = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				Estoque estoque = new Estoque();
				Categoria categoria = new Categoria();
				Fornecedor fornecedor = new Fornecedor();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
				produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
				produto.setPercentual(rs.getDouble("percentual"));
				produto.setLucro(rs.getBigDecimal("lucro"));
				produto.setImagem(rs.getString("imagem"));
				estoque.setId(rs.getInt("fk_estoque"));
				categoria.setId(rs.getInt("fk_categoria"));
				fornecedor.setId(rs.getInt("fk_fornecedor"));
				fornecedor.setNome(rs.getString("fornecedores.nome"));
				produto.setCategoria(categoria);
				produto.setEstoque(estoque);
				produto.setFornecedor(fornecedor);
				produtos.add(produto);
			}
			return produtos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Verifica se Produto existe

	public boolean existProduto(Produto produto) {
		String sql = "select * from Produtos where Produtos.nome like ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			String termo = "%" + produto.getNome() + "%";
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

	// Adicionar e Alterar Produto
	public void adicionaAltera(Object object) {
		Produto produto = (Produto) object;
		String sql = "";

		if (produto.getId() == null) {
			sql = "insert into Produtos (nome, descricao, indicacao, volume, "
					+ " custoUnid, sugestaoVenda, fk_categoria, fk_estoque, " + " lucro, percentual, imagem)"
					+ " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		} else {
			sql = "update Produtos set nome=?, descricao=?, indicacao=?, "
					+ " volume=?, custoUnid=?, sugestaoVenda=?, fk_categoria=?, " + " fk_estoque=?, imagem=? "
					+ " where id=" + produto.getId();
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getIndicacao());
			stmt.setString(4, produto.getVolume());
			stmt.setBigDecimal(5, produto.getCustoUnid());
			stmt.setBigDecimal(6, produto.getSugestaoVenda());
			stmt.setInt(7, produto.getCategoria().getId());
			stmt.setInt(8, produto.getEstoque().getId());
			stmt.setBigDecimal(9, produto.getLucro());
			stmt.setDouble(10, produto.getPercentual());
			stmt.setString(11, produto.getImagem());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Alterar Produto
	public void alterar(Object object) {
		Produto produto = (Produto) object;
		String sql = "update Produtos set nome=?, descricao=?, indicacao=?, "
				+ " volume=?, custoUnid=?, sugestaoVenda=?, fk_categoria=?, "
				+ " fk_estoque=?, lucro=?, percentual=?, imagem=? " + " where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getIndicacao());
			stmt.setString(4, produto.getVolume());
			stmt.setBigDecimal(5, produto.getCustoUnid());
			stmt.setBigDecimal(6, produto.getSugestaoVenda());
			stmt.setInt(7, produto.getCategoria().getId());
			// stmt.setInt(7, 96);
			stmt.setInt(8, produto.getEstoque().getId());
			stmt.setBigDecimal(9, produto.getLucro());
			stmt.setDouble(10, produto.getPercentual());
			stmt.setString(11, produto.getImagem());
			stmt.setInt(12, produto.getId());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Remove Produto
	public void remover(Object object) {
		Produto produto = (Produto) object;
		String sql = "Delete from Produtos where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produto.getId());
			stmt.execute();
			System.out.println("Produto removido");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// Busca Produto por id
	public Object buscaPorId(Object object) {
		Produto produtoBuscado = (Produto) object;
		Produto produto = new Produto();
		String sql = "select * from Produtos join Estoques "
				+ " on Estoques.id = Produtos.fk_estoque left join Fornecedores on Fornecedores.id = Produtos.fk_fornecedor where Produtos.id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produtoBuscado.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Estoque estoque = new Estoque();
				Categoria categoria = new Categoria();
				Fornecedor fornecedor = new Fornecedor();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
				produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
				produto.setPercentual(rs.getDouble("percentual"));
				produto.setLucro(rs.getBigDecimal("lucro"));
				produto.setImagem(rs.getString("imagem"));

				estoque.setId(rs.getInt("fk_estoque"));
				estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
				estoque.setQtdSaida(rs.getInt("qtdSaida"));
				estoque.setQtdMinima(rs.getInt("qtdMinima"));
				estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));

				categoria.setId(rs.getInt("fk_categoria"));
				categoria.setNome(rs.getString("nome"));

				fornecedor.setId(rs.getInt("fk_fornecedor"));
				fornecedor.setNome(rs.getString("fornecedores.nome"));
				produto.setEstoque(estoque);
				produto.setCategoria(categoria);
				produto.setFornecedor(fornecedor);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produto;
	}

	// Busca Imagem separadamente baseado no id do produto
	public String recuperaImagem(int id) {

		String sql = "select imagem from Produtos where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("imagem");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	// Busca Produto por nome
	public List<Object> buscaPorNome(Object object) {
		Produto p = (Produto) object;
		List<Object> produtos = new ArrayList<>();
		if (!existProduto(p)) {
			System.out.println("Produto n�o existe.");
		} else {
			String sql = "select produtos.*, Estoques.* from produtos "
					+ "join estoques on produtos.fk_estoque = estoques.id " + "where produtos.nome like ?";

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				String termo = "%" + p.getNome() + "%";
				stmt.setString(1, termo);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Produto produto = new Produto();
					produto.setId(rs.getInt("id"));
					produto.setNome(rs.getString("nome"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setIndicacao(rs.getString("indicacao"));
					produto.setVolume(rs.getString("volume"));
					produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
					produto.setPercentual(rs.getDouble("percentual"));
					produto.setLucro(rs.getBigDecimal("lucro"));
					produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
					produto.setImagem(rs.getString("imagem"));

					Estoque estoque = new Estoque();
					estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
					estoque.setQtdSaida(rs.getInt("qtdSaida"));
					estoque.setQtdMinima(rs.getInt("qtdMinima"));
					estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));
					produto.setEstoque(estoque);

					produtos.add(produto);

				}
				return produtos;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return produtos;
	}

	// Busca maxId
	public int buscaMaiorId() {
		String sql = "Select max(id) from produtos";
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

	// Busca os 5 produtos mais vendidos
	public List<Produto> topList() {
		String sql = "select produtos.*, estoques.* from produtos inner join estoques order by qtdSaida desc limit 5";
		List<Produto> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Estoque estoque = new Estoque();
				Produto produto = new Produto();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
				produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
				produto.setPercentual(rs.getDouble("percentual"));
				produto.setLucro(rs.getBigDecimal("lucro"));
				produto.setImagem(rs.getString("imagem"));

				estoque.setId(rs.getInt("fk_estoque"));
				estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
				estoque.setQtdSaida(rs.getInt("qtdSaida"));
				estoque.setQtdMinima(rs.getInt("qtdMinima"));
				estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));

				produto.setEstoque(estoque);

				list.add(produto);
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Produtos Na reserva
	public List<Produto> reservaList() {
		String sql = "select produtos.*, estoques.* from produtos inner join estoques on produtos.fk_estoque = estoques.id where (qtdDisponivel<qtdMinima) limit 5";
		List<Produto> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Estoque estoque = new Estoque();
				Produto produto = new Produto();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
				produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
				produto.setPercentual(rs.getDouble("percentual"));
				produto.setLucro(rs.getBigDecimal("lucro"));
				produto.setImagem(rs.getString("imagem"));

				estoque.setId(rs.getInt("fk_estoque"));
				estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
				estoque.setQtdSaida(rs.getInt("qtdSaida"));
				estoque.setQtdMinima(rs.getInt("qtdMinima"));
				estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));

				produto.setEstoque(estoque);

				list.add(produto);
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// produtos esgotados
	public List<Produto> esgotadoList() {
		String sql = "select produtos.*, estoques.* from produtos right join estoques on produtos.fk_estoque = estoques.id where (estoques.qtdDisponivel<=?) limit ?";
		List<Produto> list = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, 0);
			stmt.setInt(2, 5);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Estoque estoque = new Estoque();
				Produto produto = new Produto();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
				produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
				produto.setPercentual(rs.getDouble("percentual"));
				produto.setLucro(rs.getBigDecimal("lucro"));
				produto.setImagem(rs.getString("imagem"));

				estoque.setId(rs.getInt("fk_estoque"));
				estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
				estoque.setQtdSaida(rs.getInt("qtdSaida"));
				estoque.setQtdMinima(rs.getInt("qtdMinima"));
				estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));

				produto.setEstoque(estoque);

				list.add(produto);
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Retorna o valor Investido
	public Object getTotalInvestido() {
		String sql = "select sum(produtos.custoUnid * estoques.qtdEntrada) "
				+ "from produtos join estoques on fk_estoque = estoques.id";
		Object totalInvestido = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				totalInvestido = rs.getBigDecimal(1);
			}

			if (totalInvestido == null) {
				totalInvestido = new BigDecimal("0.00");
			}
			return totalInvestido;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

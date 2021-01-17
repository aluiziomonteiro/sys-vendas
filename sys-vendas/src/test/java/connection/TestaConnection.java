package connection;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;

/**
 * @author Aluizio Monteiro
 */

public class TestaConnection {

	public static void main(String[] args) {
		try(Connection connection = new ConnectionFactory().
				getConnection()){
			System.out.println("Conectado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Falha ao se conectar!");
			throw new RuntimeException(e);
		}
	}
}

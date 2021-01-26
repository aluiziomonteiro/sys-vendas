package br.com.aluizio.sysvendas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Aluizio Monteiro
 */

public class ConnectionFactory {
    private String user = "root";
    private String pass = "root";
    private String server = "localhost";
    private String database = "db_sys_vendas";
    private String driver = "jdbc:mysql:";
    private String timezone = "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private String chave = "&allowPublicKeyRetrieval=true";

    private String url = driver + "//" + server + "/" + database + timezone + chave;

    public Connection getConnection() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


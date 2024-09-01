package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String url = "jdbc:mysql://localhost:3306/projetopoo";
	private static final String user = "root";
	private static final String password = "123456";
	
	private static Connection conn;
	
	public static Connection getConexao() {
		
		if(conn==null) {
			try {
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}

				

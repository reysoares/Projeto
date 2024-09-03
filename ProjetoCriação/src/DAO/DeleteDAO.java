package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.ButtonsController;


public class DeleteDAO {
	

	public void deletarItem(int id) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = Conexao.getConexao();

	        String sql = "DELETE FROM PRODUTOS WHERE idproduto = ?";
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, id);
 
	        int rowsAffected = statement.executeUpdate();
	        if (rowsAffected > 0) {
	            ButtonsController.getInstance().notificarDel();
	        } else {
	            System.out.println("Nenhum item encontrado com o ID fornecido.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (statement != null) statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}

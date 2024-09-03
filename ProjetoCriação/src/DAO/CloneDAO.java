package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.ButtonsController;

public class CloneDAO {
	
	public static void  clonarItem(int idProduto, String nome, String tipo, Double preco) {
        String sql = "INSERT INTO PRODUTOS (NOME, TIPO, PREÇO) VALUES (?, ?, ?)";
        
        try {
        	Connection conn = Conexao.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, nome);
            pstmt.setString(2, tipo);
            pstmt.setDouble(3, preco);

            pstmt.executeUpdate();
            pstmt.close();
            ButtonsController.getInstance().notificarClone();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao clonar item: " + e.getMessage());
        }
    
	}
	
}


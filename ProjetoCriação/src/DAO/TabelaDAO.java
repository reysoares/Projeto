package DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TabelaDAO {

    public static List<String[]> getTabela() {
        List<String[]> data = new ArrayList<>();
        String sql = "SELECT * FROM projetopoo.produtos";

        try {
        	Connection conn = Conexao.getConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String[] row = new String[4];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                data.add(row);
            }
            
            rs.close();
            stmt.close();
 
            
        } catch (SQLException e) {
            e.printStackTrace(); // Log or handle the SQL exception
        }
        
        return data;
    }
}

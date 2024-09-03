package Controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.CloneDAO;
import DAO.TabelaDAO;


public class ManipuladorCopy extends Manipulador{

	@Override
	public void tratarRequisicao(String cmd, int id, StrategyOrdenacao estrategia, JTable tbEstoque) {
		if(cmd.equals("Clonar")) {
			int selectedRow = tbEstoque.getSelectedRow();
			String nome = (String) tbEstoque.getValueAt(selectedRow, 1);
			String tipo = (String) tbEstoque.getValueAt(selectedRow, 2);
			String precoString = (String) tbEstoque.getValueAt(selectedRow, 3);
			double preco = Double.parseDouble(precoString);
			
			CloneDAO.clonarItem(id, nome, tipo, preco);
			
			String[] columnNames = {"id", "Nome", "Tipo", "Preço"};
			List<String[]> tabela = TabelaDAO.getTabela(estrategia);
			tbEstoque.setModel(new DefaultTableModel(tabela.toArray(new String[0][0]), columnNames));
	    
		}else if(proximo!=null) {
			proximo.tratarRequisicao(cmd, id, estrategia, tbEstoque);
		}
		

	}

}

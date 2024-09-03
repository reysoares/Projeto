package Controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.DeleteDAO;
import DAO.TabelaDAO;

public class ManipuladorDel extends Manipulador{

	@Override
	public void tratarRequisicao(String cmd, int id, StrategyOrdenacao estrategia, JTable tbEstoque) {
		if(cmd.equals("Deletar")) {
			new DeleteDAO().deletarItem(id);
			String[] columnNames = {"id", "Nome", "Tipo", "Preço"};
			List<String[]> tabela = TabelaDAO.getTabela(estrategia);
			tbEstoque.setModel(new DefaultTableModel(tabela.toArray(new String[0][0]), columnNames));
		}
		else if(proximo!=null) {
			proximo.tratarRequisicao(cmd, id, estrategia, tbEstoque);
			
		}
		
	}
	
	
}

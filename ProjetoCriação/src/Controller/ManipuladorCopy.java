package Controller;

import java.util.List;

import javax.swing.JFrame;

import javax.swing.JTable;

import DAO.CloneDAO;
import DAO.TabelaDAO;
import view.TelaEstoque;

public class ManipuladorCopy extends Manipulador{

	@Override
	public void tratarRequisicao(String cmd, int id, JFrame telaEstoque, JTable tbEstoque) {
		if(cmd.equals("Clonar")) {
			int selectedRow = tbEstoque.getSelectedRow();
			String nome = (String) tbEstoque.getValueAt(selectedRow, 1);
			String tipo = (String) tbEstoque.getValueAt(selectedRow, 2);
			String precoString = (String) tbEstoque.getValueAt(selectedRow, 3);
			double preco = Double.parseDouble(precoString);
			
			CloneDAO.clonarItem(id, nome, tipo, preco);
			telaEstoque.dispose();
			List<String[]> tabela = TabelaDAO.getTabela();
			new TelaEstoque(tabela).setLocationRelativeTo(null);;
	    
		}else if(proximo!=null) {
			proximo.tratarRequisicao(cmd, id, telaEstoque, tbEstoque);
		}
		

	}

}

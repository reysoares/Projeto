package Controller;

import javax.swing.JTable;
import DAO.CloneDAO;

public class ManipuladorCopy extends Manipulador{

	@Override
	public void tratarRequisicao(String cmd, int id, JTable tbEstoque) {
		if(cmd.equals("Clonar")) {
			int selectedRow = tbEstoque.getSelectedRow();
			String nome = (String) tbEstoque.getValueAt(selectedRow, 1);
			String tipo = (String) tbEstoque.getValueAt(selectedRow, 2);
			String precoString = (String) tbEstoque.getValueAt(selectedRow, 3);
			double preco = Double.parseDouble(precoString);
			
			CloneDAO.clonarItem(id, nome, tipo, preco);
			
			ButtonsController.getInstance().atualizar();
	    
		}else if(proximo!=null) {
			proximo.tratarRequisicao(cmd, id, tbEstoque);
		}
		

	}

}

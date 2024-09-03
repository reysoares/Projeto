package Controller;

import javax.swing.JTable;
import DAO.DeleteDAO;


public class ManipuladorDel extends Manipulador{

	@Override
	public void tratarRequisicao(String cmd, int id, JTable tbEstoque) {
		if(cmd.equals("Deletar")) {
			new DeleteDAO().deletarItem(id);
			ButtonsController.getInstance().atualizar();
		}
		else if(proximo!=null) {
			proximo.tratarRequisicao(cmd, id, tbEstoque);
			
		}
		
	}
	
	
}

package Controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import DAO.DeleteDAO;
import DAO.TabelaDAO;
import view.TelaEstoque;

public class ManipuladorDel extends Manipulador{

	@Override
	public void tratarRequisicao(String cmd, int id, JFrame telaEstoque, JTable tbEstoque) {
		if(cmd.equals("Deletar")) {
			new DeleteDAO().deletarItem(id);
			telaEstoque.dispose();
			List<String[]> tabela = TabelaDAO.getTabela();
			new TelaEstoque(tabela).setLocationRelativeTo(null);
		}
		else if(proximo!=null) {
			proximo.tratarRequisicao(cmd, id, telaEstoque, tbEstoque);
			
		}
		
	}
	
	
}

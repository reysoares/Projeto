package Controller;

import java.util.List;

import javax.swing.JFrame;

import DAO.DeleteProduto;
import DAO.TabelaDAO;
import view.TelaEstoque;

public class ManipuladorDel extends Manipulador{

	@Override
	public void tratarRequisicao(String cmd, int id, JFrame telaEstoque) {
		if(cmd.equals("Deletar")) {
			new DeleteProduto().deletarItem(id);
			telaEstoque.dispose();
			List<String[]> tabela = TabelaDAO.getTabela();
			new TelaEstoque(tabela).setLocationRelativeTo(null);;
		}
		else if(proximo!=null) {
			proximo.tratarRequisicao(cmd, id, telaEstoque);
			
		}
		
	}
	
	
}

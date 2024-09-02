package view;

import javax.swing.JOptionPane;

import Entity.Produto;

public class Observador {
	
	public void notificarAdd(Produto p) {
		JOptionPane.showMessageDialog(null, p.getNome()+": "+p.getTipo()+" foi Adicionado!");
	}
	public void notificarDel() {
		JOptionPane.showMessageDialog(null, "Item deletado com sucesso!");
	}
}

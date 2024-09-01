package view;

import javax.swing.JOptionPane;

import Entity.Produto;

public class Observador {
	
	public void notificar(Produto p) {
		JOptionPane.showMessageDialog(null, p.getNome()+": "+p.getTipo()+" foi Adicionado!");
	}
}

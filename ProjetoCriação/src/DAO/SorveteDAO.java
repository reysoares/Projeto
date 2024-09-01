package DAO;

import javax.swing.JOptionPane;

import Entity.Sorvete;

public class SorveteDAO {
	
	public Sorvete criarSorvete(String sabor, String calda, String granulado, double preco) {
		return new Sorvete.Builder()
				.setSabor(sabor)
				.setCalda(calda)
				.setGranulado(granulado)
				.setPreco(preco)
				.criar();
	}
	//adicionar o sorvete criado na tabela
	public void pedirSorvete(String sabor, String calda, String granulado, double preco) {
		Sorvete sorvete = criarSorvete(sabor, calda, granulado, preco);
		new ProdutoDAO().adicionarProduto(sorvete);
		JOptionPane.showMessageDialog(null, "Sorvete de "+sorvete.getTipo()+" foi Adicionado!");
		
	}
}

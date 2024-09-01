package DAO;
import javax.swing.JOptionPane;

import Entity.CremeDental;
import Entity.Produto;
import Entity.Shampoo;

//Factory Method
public class FabricaHigiene {
	
	public Produto criarProduto(String nome) {
		if(nome.equals("Shampoo")) {
			return new Shampoo();
		}else if(nome.equals("Creme Dental")) {
			return new CremeDental();
		}return null;
	}
	
	public void pedirProduto(String nome, double preco, String marca){
		Produto produto = criarProduto(nome);
		produto.setPreco(preco);
		produto.setTipo(marca);
		new ProdutoDAO().adicionarProduto(produto);
		JOptionPane.showMessageDialog(null, produto.getNome()+" "+marca+" foi adicionado!");
	}
}

package DAO;

import Entity.Pizza;
import view.Observador;

public class PizzaDAO {
	
	public Pizza criarPizza(String massa, String molho, String sabor, double preco) {
		
		return new Pizza.Builder()
				.setMassa(massa)
				.setMolho(molho)
				.setSabor(sabor)
				.setPreco(preco)
				.criar();
		
	}
	//adicionar a pizza criada na tabela
	public void pedirPizza(String massa, String molho, String sabor, double preco) {
		Pizza pizza = criarPizza(massa, molho, sabor, preco);
		new ProdutoDAO().adicionarProduto(pizza);
	}
	

}
package Entity;

public abstract class Produto {
	
	//Atributos genéricos
	private double preco = 0.00;
	private String nome;
	private String tipo;
	
	//Gets e Sets
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}

package Entity;

public class Pizza extends Produto{
		
	//Clonador
	@Override
	public Produto clonar() {
		return new Pizza(this.massa, this.molho, super.getTipo(), super.getPreco());
	}
	//Atributos
	private String massa;
	private String molho;
	
	//Construtor clone
	public Pizza(String massa, String molho, String sabor, double preco) {
		this.massa=massa;
		this.molho=molho;
		super.setTipo(sabor);
		super.setPreco(preco);
		super.setNome("Pizza");
		
	}
	
	//Construtor Builder
	private Pizza(Builder builder) {
		this.massa=builder.massa;
		this.molho=builder.molho;
		super.setTipo(builder.tipo);
		super.setPreco(builder.preco);
		super.setNome("Pizza");
		
	}
	//Classe builder
	public static class Builder{
		private String massa;
		private String molho;
		private String tipo;
		private double preco;
		
		public Builder setMassa(String massa) {
			this.massa=massa;
			return this;
		}
		public Builder setMolho(String molho) {
			this.molho=molho;
			return this;
		}
		public Builder setSabor(String sabor) {
			this.tipo=sabor;
			return this;
		}
		public Builder setPreco(double preco) {
			this.preco=preco;
			return this;
		}
		public Pizza criar() {
			return new Pizza(this);
		}
	}
}

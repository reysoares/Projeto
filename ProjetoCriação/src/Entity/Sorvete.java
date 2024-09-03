package Entity;

public class Sorvete extends Produto{


	//atributos
	private String calda;
	private String granulado;
	
	//construtor builder
	private Sorvete(Builder builder) {
		super.setTipo(builder.tipo);
		this.calda=builder.calda;
		this.granulado=builder.granulado;
		super.setPreco(builder.preco);
		super.setNome("Sorvete");
	}
	
	public static class Builder{
		private String tipo;
		private String calda;
		private String granulado;
		private double preco;
		
		public Builder setSabor(String sabor) {
			this.tipo=sabor;
			return this;
		}
		public Builder setCalda(String calda) {
			this.calda=calda;
			return this;
		}
		public Builder setGranulado(String granulado) {
			this.granulado=granulado;
			return this;
		}
		public Builder setPreco(double preco) {
			this.preco=preco;
			return this;
		}
		public Sorvete criar() {
			return new Sorvete(this);
		}
		
	}

}

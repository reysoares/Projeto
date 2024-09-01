package Entity;

public class Shampoo extends Produto{

	@Override
	public Produto clonar() {
		return new Shampoo(this.getPreco(), this.getTipo());
	}
	//Contrutor para Clonar
	public Shampoo(double preco,String tipo) {
		
		super.setPreco(preco);
		super.setTipo(tipo);
		super.setNome("Shampoo");
	}
	//Construtor Padrão
	public Shampoo() {
		super.setNome("Shampoo");
	}
	

}

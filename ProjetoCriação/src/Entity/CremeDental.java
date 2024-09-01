package Entity;

public class CremeDental extends Produto{
	
	@Override
	public Produto clonar() {
		return new CremeDental(this.getPreco(),this.getTipo());
	}
	//Contrutor para clonar
	public CremeDental(double preco, String marca) {
		super.setPreco(preco);
		super.setTipo(marca);
		super.setNome("Creme Dental");
	}
	//Construtor padrão
	public CremeDental() {
		super.setNome("Creme Dental");
	}
	

}

package Controller;

public class OrdenacaoCrescente implements StrategyOrdenacao{

	@Override
	public String formaDeOrdenar() {
		return " ORDER BY idproduto ASC";
	}

}

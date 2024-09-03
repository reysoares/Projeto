package Controller;

public class OrdenacaoDecrescente implements StrategyOrdenacao{

	@Override
	public String formaDeOrdenar() {
		return " ORDER BY idproduto DESC";
	}

}

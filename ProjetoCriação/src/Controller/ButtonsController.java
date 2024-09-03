package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.FabricaHigiene;
import DAO.PizzaDAO;
import DAO.SorveteDAO;
import DAO.TabelaDAO;
import Entity.Produto;
import view.TelaPizza;
import view.TelaShampoo;
import view.TelaSorvete;
import view.Observador;
import view.TelaCremeDental;
import view.TelaCriacao;
import view.TelaEstoque;

public class ButtonsController implements ActionListener{
	
	private static ButtonsController instance;
	
	private ButtonsController() {}
	
	public static ButtonsController getInstance(){
		if(instance==null) {
			instance=new ButtonsController();
		}
		return instance;
	}
	
	//Objetos Dao
	FabricaHigiene factory = new FabricaHigiene();
	PizzaDAO pizzaBuilder = new PizzaDAO();
	SorveteDAO sorveteBuilder = new SorveteDAO();
	Observador observer = new Observador();
	private StrategyOrdenacao estrategia = new OrdenacaoCrescente();
	
	
	//Telas
	private TelaCriacao telaCriacao;
	private TelaPizza telaPizza;
	private TelaSorvete telaSorvete;
	private TelaShampoo telaShampoo;
	private TelaCremeDental telaCreme;
	private TelaEstoque telaEstoque;
	
	
	// Preço e Tipo/Sabor dos produtos
	private JFormattedTextField tfPreco;
	private JComboBox cbTipo;
	
	//Elementos da pizza
	private JComboBox cbMassa;
	private JComboBox cbMolho;
	
	//Elementos do Sorvete
	private JComboBox cbCalda;
	private JComboBox cbGranulado;
	
	//Elementos tel de Estoque
	private JTable tbEstoque;
	private JComboBox cbFiltrar;
	
	

	//Ações dos Botões
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		//Abrir as telas
		if(cmd.equals("openPizza")){
			new TelaPizza().setLocationRelativeTo(null);
		}
		if(cmd.equals("openSorvete")) {
			new TelaSorvete().setLocationRelativeTo(null);
		}
		if(cmd.equals("openShampoo")){
			new TelaShampoo().setLocationRelativeTo(null);
		}
		if(cmd.equals("openCremeDental")){
			new TelaCremeDental().setLocationRelativeTo(null);
		}
		if(cmd.equals("openEstoque")){
			if(telaEstoque==null) {
				List<String[]> tabela = TabelaDAO.getTabela(estrategia);
				new TelaEstoque(tabela).setLocationRelativeTo(null);
			}else {
				atualizar();
				telaEstoque.setVisible(true);
			}
		}
		
		//Fechar as telas
		if(cmd.equals("VoltarPizza")){
			telaPizza.dispose();
		}
		if(cmd.equals("VoltarSorvete")){
			telaSorvete.dispose();
		}
		if(cmd.equals("VoltarShampoo")){
			telaShampoo.dispose();
		}
		if(cmd.equals("VoltarCremeDental")){
			telaCreme.dispose();
		}
		if(cmd.equals("VoltarEstoque")) {
			telaEstoque.setVisible(false);
		}
		
		//Criar Produtos
		if(cmd.equals("Shampoo") || cmd.equals("Creme Dental")){
			if(tfPreco.getValue()!=null) {
			double preco = (double) tfPreco.getValue();
			String marca = (String) cbTipo.getSelectedItem();
			factory.pedirProduto(cmd,preco,marca);
			}else {
				JOptionPane.showMessageDialog(null, "Insira o preço!");
			}
		}
		if(cmd.equals("Pizza")) {
			if(tfPreco.getValue()!=null) {
				double preco = (double) tfPreco.getValue();
				String tipo = (String) cbTipo.getSelectedItem();
				String massa = (String) cbMassa.getSelectedItem();
				String molho = (String) cbMolho.getSelectedItem();
				pizzaBuilder.pedirPizza(massa, molho, tipo, preco);
			}else {
				JOptionPane.showMessageDialog(null, "Insira o preço!");
			}
		}
		if(cmd.equals("Sorvete")) {
			if(tfPreco.getValue()!=null) {
				double preco = (double) tfPreco.getValue();
				String tipo = (String) cbTipo.getSelectedItem();
				String calda = (String) cbCalda.getSelectedItem();
				String granulado = (String) cbGranulado.getSelectedItem();
				sorveteBuilder.pedirSorvete(tipo, calda, granulado, preco);
			}
			else {
				JOptionPane.showMessageDialog(null, "Insira o preço!");
			}
		}
		
		// Deletar e Clonar item do Estoque
		if(cmd.equals("Deletar") || cmd.equals("Clonar")) {
			int selectedRow = tbEstoque.getSelectedRow();
			if (selectedRow != -1) {
				String id = (String) tbEstoque.getValueAt(selectedRow, 0);
				int idint = Integer.parseInt(id);
				ManipuladorDel manipulador1 = new ManipuladorDel();
				ManipuladorCopy manipulador2 = new ManipuladorCopy();
				manipulador1.definirProximo(manipulador2);
				manipulador1.tratarRequisicao(cmd, idint, tbEstoque);
			}
			else {
				JOptionPane.showMessageDialog(null, "Nenhum item selecionado.");
			}
		}
		//Ordem recente ou antigo
		if(cmd.equals("AlterarFiltro")) {
			String ordemSelecionada = (String) cbFiltrar.getSelectedItem();
			if(ordemSelecionada.equals("Mais antigos")) {
				setEstrategia(new OrdenacaoCrescente());
				atualizar();
			}else {
				setEstrategia(new OrdenacaoDecrescente());
				atualizar();
			}
		}
	
	}
	public void atualizar() {
		String[] columnNames = {"id", "Nome", "Tipo", "Preço"};
		List<String[]> novaTabela = TabelaDAO.getTabela(estrategia);
		tbEstoque.setModel(new DefaultTableModel(novaTabela.toArray(new String[0][0]), columnNames));
	}
	//Metodo para notificar
	public void notificarProdutoAdicionado(Produto p) {
		observer.notificarAdd(p);
	}
	
	public void notificarDel() {
		observer.notificarDel();
	}
	public void notificarClone() {
		observer.notificarCopy();
	}
	//Definir estrategia de ordenação da tabela de estoque
	public StrategyOrdenacao getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(StrategyOrdenacao estrategia) {
		this.estrategia = estrategia;
	}
	
	//setar As telas como atributos
	public void setTelaCriacao(TelaCriacao t) {
		this.telaCriacao=t;
	}

	public void setTelaPizza(TelaPizza telaPizza) {
		this.telaPizza = telaPizza;
	}

	public void setTelaSorvete(TelaSorvete telaSorvete) {
		this.telaSorvete = telaSorvete;
	}
	public void setTelaShampoo(TelaShampoo telaShampoo) {
		this.telaShampoo = telaShampoo;
	}
	public void setTelaCreme(TelaCremeDental telaCreme) {
		this.telaCreme = telaCreme;
	}
	
	//setar alementos das telas
	public JFormattedTextField getTfPreco() {
		return tfPreco;
	}

	public JTable getTbEstoque() {
		return tbEstoque;
	}

	public void setTbEstoque(JTable tbEstoque) {
		this.tbEstoque = tbEstoque;
	}

	public void setTfPreco(JFormattedTextField tfPreco) {
		this.tfPreco = tfPreco;
	}
	
	public JComboBox getCbTipo() {
		return cbTipo;
	}

	public void setCbTipo(JComboBox cbTipo) {
		this.cbTipo = cbTipo;
	}

	public JComboBox getCbMassa() {
		return cbMassa;
	}

	public void setCbMassa(JComboBox cbMassa) {
		this.cbMassa = cbMassa;
	}

	public JComboBox getCbMolho() {
		return cbMolho;
	}

	public void setCbMolho(JComboBox cbMolho) {
		this.cbMolho = cbMolho;
	}

	public JComboBox getCbCalda() {
		return cbCalda;
	}

	public void setCbCalda(JComboBox cbCalda) {
		this.cbCalda = cbCalda;
	}

	public JComboBox getCbGranulado() {
		return cbGranulado;
	}

	public void setCbGranulado(JComboBox cbGranulado) {
		this.cbGranulado = cbGranulado;
	}

	public TelaEstoque getTelaEstoque() {
		return telaEstoque;
	}

	public void setTelaEstoque(TelaEstoque telaEstoque) {
		this.telaEstoque = telaEstoque;
	}

	public JComboBox getCbFiltrar() {
		return cbFiltrar;
	}

	public void setCbFiltrar(JComboBox cbFiltrar) {
		this.cbFiltrar = cbFiltrar;
	}


}

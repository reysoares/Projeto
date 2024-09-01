package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import DAO.FabricaHigiene;
import DAO.PizzaDAO;
import DAO.SorveteDAO;
import view.TelaPizza;
import view.TelaShampoo;
import view.TelaSorvete;
import view.TelaCremeDental;
import view.TelaCriacao;

public class ButtonsController implements ActionListener{
	
	//Objetos Dao
	FabricaHigiene factory = new FabricaHigiene();
	PizzaDAO pizzaBuilder = new PizzaDAO();
	SorveteDAO sorveteBuilder = new SorveteDAO();
	
	//Telas
	private TelaCriacao telaCriacao;
	private TelaPizza telaPizza;
	private TelaSorvete telaSorvete;
	private TelaShampoo telaShampoo;
	private TelaCremeDental telaCreme;
	
	// Preço e Tipo/Sabor dos produtos
	private JFormattedTextField tfPreco;
	private JComboBox cbTipo;
	
	//Elementos da pizza
	private JComboBox cbMassa;
	private JComboBox cbMolho;
	
	//Elementos do Sorvete
	private JComboBox cbCalda;
	private JComboBox cbGranulado;
	
	

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


}

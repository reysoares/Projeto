package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ButtonsController;
import DAO.TabelaDAO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbEstoque;

	public TelaEstoque(List<String[]> tabela) {
		
		setTitle("Estoque de Produtos");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setActionCommand("VoltarEstoque");
		btnVoltar.setBounds(507, 142, 137, 23);
		contentPane.add(btnVoltar);
		
		String[] columnNames = {"id", "Nome", "Tipo", " Preço"};
		
		tbEstoque = new JTable(tabela.toArray(new String[0][0]), columnNames);
		tbEstoque.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tbEstoque.setBounds(36, 224, 608, 230);
		contentPane.add(tbEstoque);
		
		JScrollPane scrollPane = new JScrollPane(tbEstoque);
		scrollPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        scrollPane.setBounds(36, 190, 608, 264); 
        contentPane.add(scrollPane);
		
		JLabel lblEstoque = new JLabel("ESTOQUE DE PRODUTOS");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblEstoque.setBounds(204, 43, 326, 73);
		contentPane.add(lblEstoque);
		
		JButton btnDeletarItem = new JButton("Deletar Item");
		btnDeletarItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletarItem.setBorderPainted(false);
		btnDeletarItem.setBackground(Color.LIGHT_GRAY);
		btnDeletarItem.setActionCommand("Deletar");
		btnDeletarItem.setBounds(360, 142, 137, 23);
		contentPane.add(btnDeletarItem);
		
		JButton btnClonar = new JButton("Clonar Item");
		btnClonar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClonar.setBorderPainted(false);
		btnClonar.setBackground(Color.LIGHT_GRAY);
		btnClonar.setActionCommand("Clonar");
		btnClonar.setBounds(213, 142, 137, 23);
		contentPane.add(btnClonar);
		
		JComboBox cbFiltrar = new JComboBox();
		cbFiltrar.setActionCommand("AlterarFiltro");
		cbFiltrar.setModel(new DefaultComboBoxModel(new String[] {"Mais antigos", "Mais recentes"}));
		cbFiltrar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbFiltrar.setBounds(82, 142, 121, 23);
		contentPane.add(cbFiltrar);
		
		JLabel lblExibir = new JLabel("Exibir:");
		lblExibir.setBounds(36, 146, 46, 14);
		contentPane.add(lblExibir);
		
		
		ButtonsController btnController = ButtonsController.getInstance();
		btnController.setTelaEstoque(this);
		btnController.setTbEstoque(tbEstoque);
		btnController.setCbFiltrar(cbFiltrar);
		
		btnVoltar.addActionListener(btnController);
		btnDeletarItem.addActionListener(btnController);
		btnClonar.addActionListener(btnController);
		cbFiltrar.addActionListener(btnController);
	}
}

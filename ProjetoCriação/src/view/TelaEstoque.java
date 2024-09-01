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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbEstoque;

	public TelaEstoque() {
		
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
		btnVoltar.setBounds(457, 142, 187, 23);
		contentPane.add(btnVoltar);
		
		List<String[]> tabela = TabelaDAO.getTabela();
		String[] columnNames = {"id", "Nome", "Tipo", " Preço"};
		
		
		tbEstoque = new JTable(tabela.toArray(new String[0][0]), columnNames);
		tbEstoque.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tbEstoque.setBounds(36, 224, 608, 230);
		contentPane.add(tbEstoque);
		
		JLabel lblEstoque = new JLabel("ESTOQUE DE PRODUTOS");
		lblEstoque.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblEstoque.setBounds(204, 43, 326, 73);
		contentPane.add(lblEstoque);
		
		JLabel lblNewLabel = new JLabel("Preço R$");
		lblNewLabel.setBounds(545, 209, 61, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMarcasabor = new JLabel("Marca/Sabor");
		lblMarcasabor.setBounds(388, 209, 75, 14);
		contentPane.add(lblMarcasabor);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(241, 209, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblId = new JLabel("ID Produto");
		lblId.setBounds(85, 209, 61, 14);
		contentPane.add(lblId);
		
		ButtonsController btnController = new ButtonsController();
		btnController.setTelaEstoque(this);
		
		btnVoltar.addActionListener(btnController);
	}
}

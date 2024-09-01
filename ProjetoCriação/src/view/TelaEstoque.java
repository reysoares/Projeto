package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ButtonsController;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.util.List;

import javax.swing.JTable;

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
		btnVoltar.setBounds(488, 164, 187, 23);
		contentPane.add(btnVoltar);
		
		tbEstoque = new JTable();
		tbEstoque.setBounds(36, 224, 608, 230);
		contentPane.add(tbEstoque);
		
		ButtonsController btnController = new ButtonsController();
		btnController.setTelaEstoque(this);
		
		btnVoltar.addActionListener(btnController);
	}
}

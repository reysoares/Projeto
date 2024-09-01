package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.ButtonsController;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Cursor;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class TelaCriacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TelaCriacao() {
		
		setTitle("Menu Usuário");
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 567);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CRIAR PRODUTOS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblTitulo.setBounds(161, 46, 337, 63);
		contentPane.add(lblTitulo);
		
		JLabel lblAlimento = new JLabel("Alimentos:");
		lblAlimento.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAlimento.setBounds(72, 152, 108, 25);
		contentPane.add(lblAlimento);
		
		JButton btnPizza = new JButton("Pizza");
		btnPizza.setActionCommand("openPizza");
		btnPizza.setBorderPainted(false);
		btnPizza.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPizza.setBackground(new Color(192, 192, 192));
		btnPizza.setBounds(72, 189, 190, 35);
		contentPane.add(btnPizza);
		
		JButton btnSorvete = new JButton("Sorvete");
		btnSorvete.setActionCommand("openSorvete");
		btnSorvete.setBackground(new Color(192, 192, 192));
		btnSorvete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSorvete.setBorderPainted(false);
		btnSorvete.setBounds(72, 249, 190, 35);
		contentPane.add(btnSorvete);
		
		JButton btnShampoo = new JButton("Shampoo");
		btnShampoo.setActionCommand("openShampoo");
		btnShampoo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShampoo.setBorderPainted(false);
		btnShampoo.setBackground(Color.LIGHT_GRAY);
		btnShampoo.setBounds(358, 189, 190, 35);
		contentPane.add(btnShampoo);
		
		JButton btnCremeDental = new JButton("Creme Dental");
		btnCremeDental.setActionCommand("openCremeDental");
		btnCremeDental.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCremeDental.setBorderPainted(false);
		btnCremeDental.setBackground(Color.LIGHT_GRAY);
		btnCremeDental.setBounds(358, 249, 190, 35);
		contentPane.add(btnCremeDental);
		
		JLabel lblHigiene = new JLabel("Higiene:");
		lblHigiene.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHigiene.setBounds(358, 152, 108, 25);
		contentPane.add(lblHigiene);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setBorderPainted(false);
		btnSair.setBackground(Color.LIGHT_GRAY);
		btnSair.setBounds(72, 458, 102, 35);
		contentPane.add(btnSair);
		
		JButton btnExibirEstoque = new JButton("Exibir Estoque");
		btnExibirEstoque.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExibirEstoque.setBackground(new Color(214, 214, 214));
		btnExibirEstoque.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnExibirEstoque.setBorderPainted(false);
		btnExibirEstoque.setBounds(72, 380, 478, 35);
		contentPane.add(btnExibirEstoque);
		
		JLabel lblProdutos = new JLabel("Produtos:");
		lblProdutos.setBounds(72, 351, 62, 14);
		contentPane.add(lblProdutos);
		
		//Instanciar um controlador na tela
		ButtonsController btnController = new ButtonsController();
		btnController.setTelaCriacao(this);
		
		//Mandar ação para o Controller
		btnPizza.addActionListener(btnController);
		btnSorvete.addActionListener(btnController);
		btnShampoo.addActionListener(btnController);
		btnCremeDental.addActionListener(btnController);
		
	}
}

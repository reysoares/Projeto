package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JComboBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.NumberFormatter;

import Controller.ButtonsController;

import javax.swing.border.BevelBorder;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

public class TelaShampoo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TelaShampoo() {
		setTitle("Criar Shampoo");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblShampoo = new JLabel("SHAMPOO");
		lblShampoo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblShampoo.setBounds(183, 27, 95, 41);
		contentPane.add(lblShampoo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(26, 90, 61, 14);
		contentPane.add(lblMarca);
		
		JComboBox cbMarcaShampoo = new JComboBox();
		cbMarcaShampoo.setModel(new DefaultComboBoxModel(new String[] {"Seda", "Natura", "Dove", "Pantene"}));
		cbMarcaShampoo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbMarcaShampoo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbMarcaShampoo.setBounds(116, 88, 112, 22);
		contentPane.add(cbMarcaShampoo);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(26, 135, 61, 14);
		contentPane.add(lblPreco);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setActionCommand("Shampoo");
		btnCriar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCriar.setBorderPainted(false);
		btnCriar.setBackground(Color.LIGHT_GRAY);
		btnCriar.setBounds(26, 227, 186, 23);
		contentPane.add(btnCriar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setActionCommand("VoltarShampoo");
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(222, 227, 187, 23);
		contentPane.add(btnVoltar);
		
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Double.class);
		formatter.setMinimum(0.00);
		formatter.setAllowsInvalid(false);

		JFormattedTextField ftPreco = new JFormattedTextField(formatter);
		ftPreco.setBounds(116, 134, 61, 20);
		contentPane.add(ftPreco);
		
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblR$.setBounds(89, 135, 17, 14);
		contentPane.add(lblR$);
		
		//instancia de um Controller
		ButtonsController btnController = ButtonsController.getInstance();
		btnController.setTelaShampoo(this);
		//mandar ação do botão para o controller
		btnVoltar.addActionListener(btnController);
		btnCriar.addActionListener(btnController);
		btnController.setTfPreco(ftPreco);
		btnController.setCbTipo(cbMarcaShampoo);
	}
}

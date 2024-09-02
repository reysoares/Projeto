package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ButtonsController;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;


public class TelaPizza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public TelaPizza() {
		setTitle("Criar Pizza");
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPizza.setBounds(25, 61, 89, 51);
		contentPane.add(lblPizza);

		JComboBox cbMassa = new JComboBox();
		cbMassa.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbMassa.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbMassa.setModel(new DefaultComboBoxModel(new String[] {"Padão", "Integral"}));
		cbMassa.setBounds(115, 124, 106, 22);
		contentPane.add(cbMassa);

		JLabel lblMassa = new JLabel("Massa:");
		lblMassa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMassa.setBounds(25, 124, 51, 22);
		contentPane.add(lblMassa);

		JLabel lblMolho = new JLabel("Molho:");
		lblMolho.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMolho.setBounds(25, 160, 46, 14);
		contentPane.add(lblMolho);

		JComboBox cbMolho = new JComboBox();
		cbMolho.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbMolho.setModel(new DefaultComboBoxModel(new String[] {"Tomate", "Pesto"}));
		cbMolho.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbMolho.setBounds(115, 157, 106, 22);
		contentPane.add(cbMolho);

		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSabor.setBounds(25, 193, 46, 14);
		contentPane.add(lblSabor);

		JComboBox cbSaborPizza = new JComboBox();
		cbSaborPizza.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbSaborPizza.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbSaborPizza.setModel(new DefaultComboBoxModel(new String[] {"Calabresa", "Catupury"}));
		cbSaborPizza.setBounds(115, 190, 106, 22);
		contentPane.add(cbSaborPizza);

		JButton btnCriar = new JButton("Criar");
		btnCriar.setActionCommand("Pizza");
		btnCriar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCriar.setBackground(new Color(192, 192, 192));
		btnCriar.setBorderPainted(false);
		btnCriar.setBounds(25, 358, 186, 23);
		contentPane.add(btnCriar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setActionCommand("VoltarPizza");
		btnVoltar.setBackground(new Color(192, 192, 192));
		btnVoltar.setBorderPainted(false);
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBounds(221, 358, 187, 23);
		contentPane.add(btnVoltar);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(25, 236, 61, 14);
		contentPane.add(lblPreco);

		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblR$.setBounds(85, 236, 17, 14);
		contentPane.add(lblR$);

		//formatador de preço
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Double.class);
		formatter.setMinimum(0.00);
		formatter.setAllowsInvalid(false);

		//preço
		JFormattedTextField ftPreco = new JFormattedTextField(formatter);
		ftPreco.setBounds(114, 235, 61, 20);
		contentPane.add(ftPreco);

		//comunicação com controller

		ButtonsController btnController = new ButtonsController();

		btnController.setTelaPizza(this);
		btnController.setTfPreco(ftPreco);
		btnController.setCbTipo(cbSaborPizza);
		btnController.setCbMassa(cbMassa);
		btnController.setCbMolho(cbMolho);

		btnVoltar.addActionListener(btnController);
		btnCriar.addActionListener(btnController);
	}
}

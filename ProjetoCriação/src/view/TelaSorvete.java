package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ButtonsController;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.JFormattedTextField;


public class TelaSorvete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public TelaSorvete() {
		setTitle("Criar Sorvete");
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 444, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSorvete = new JLabel("Sorvete");
		lblSorvete.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSorvete.setBounds(167, 43, 94, 51);
		contentPane.add(lblSorvete);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setActionCommand("Sorvete");
		btnCriar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCriar.setBorderPainted(false);
		btnCriar.setBackground(Color.LIGHT_GRAY);
		btnCriar.setBounds(24, 419, 186, 23);
		contentPane.add(btnCriar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setActionCommand("VoltarSorvete");
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(220, 419, 187, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSabor.setBounds(24, 142, 65, 22);
		contentPane.add(lblSabor);
		
		JComboBox cbSaborSorvete = new JComboBox();
		cbSaborSorvete.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbSaborSorvete.setModel(new DefaultComboBoxModel(new String[] {"Chocolate", "Morango", "Menta", "Baunilha"}));
		cbSaborSorvete.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbSaborSorvete.setBounds(115, 143, 112, 22);
		contentPane.add(cbSaborSorvete);
		
		JComboBox cbCalda = new JComboBox();
		cbCalda.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbCalda.setModel(new DefaultComboBoxModel(new String[] {"Morango", "Leite Condensado", "Chocolate"}));
		cbCalda.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbCalda.setBounds(115, 187, 112, 22);
		contentPane.add(cbCalda);
		
		JComboBox cbGranulado = new JComboBox();
		cbGranulado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbGranulado.setModel(new DefaultComboBoxModel(new String[] {"Brigadeiro", "M&M"}));
		cbGranulado.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbGranulado.setBounds(115, 236, 112, 22);
		contentPane.add(cbGranulado);
		
		JLabel lblCalda = new JLabel("Calda:");
		lblCalda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCalda.setBounds(24, 186, 51, 22);
		contentPane.add(lblCalda);
		
		JLabel lblGranulado = new JLabel("Granulado:");
		lblGranulado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGranulado.setBounds(24, 235, 65, 22);
		contentPane.add(lblGranulado);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(24, 294, 61, 14);
		contentPane.add(lblPreco);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblR$.setBounds(87, 294, 17, 14);
		contentPane.add(lblR$);
		
		//formatador de preco
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Double.class);
		formatter.setMinimum(0.00);
		formatter.setAllowsInvalid(false);
		//preço
		JFormattedTextField ftPreco = new JFormattedTextField(formatter);
		ftPreco.setBounds(114, 293, 61, 20);
		contentPane.add(ftPreco);
		
		ButtonsController btnController = new ButtonsController();
		
		btnController.setTelaSorvete(this);
		btnController.setCbTipo(cbSaborSorvete);
		btnController.setCbCalda(cbCalda);
		btnController.setCbGranulado(cbGranulado);
		btnController.setTfPreco(ftPreco);
		
		btnVoltar.addActionListener(btnController);
		btnCriar.addActionListener(btnController);

	}
}

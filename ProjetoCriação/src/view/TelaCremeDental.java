package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.NumberFormatter;

import Controller.ButtonsController;
import java.awt.Cursor;

public class TelaCremeDental extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TelaCremeDental() {
		setTitle("Criar Creme Dental");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCremeDental = new JLabel("Creme Dental");
		lblCremeDental.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCremeDental.setBounds(159, 27, 144, 41);
		contentPane.add(lblCremeDental);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(26, 90, 61, 14);
		contentPane.add(lblMarca);
		
		JComboBox cbMarcaCreme = new JComboBox();
		cbMarcaCreme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbMarcaCreme.setModel(new DefaultComboBoxModel(new String[] {"Colgate", "Closeup", "Sensodyne"}));
		cbMarcaCreme.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		cbMarcaCreme.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cbMarcaCreme.setBounds(116, 88, 112, 26);
		contentPane.add(cbMarcaCreme);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(26, 135, 61, 14);
		contentPane.add(lblPreco);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setActionCommand("Creme Dental");
		btnCriar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCriar.setBorderPainted(false);
		btnCriar.setBackground(Color.LIGHT_GRAY);
		btnCriar.setBounds(26, 227, 186, 23);
		contentPane.add(btnCriar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setActionCommand("VoltarCremeDental");
		btnVoltar.setBorderPainted(false);
		btnVoltar.setBackground(Color.LIGHT_GRAY);
		btnVoltar.setBounds(222, 227, 187, 23);
		contentPane.add(btnVoltar);
		
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		formatter.setValueClass(Double.class);
		formatter.setMinimum(0.00);
		formatter.setAllowsInvalid(false);
		
		JFormattedTextField ftPrecoCD = new JFormattedTextField(formatter);
		ftPrecoCD.setBounds(116, 134, 61, 20);
		contentPane.add(ftPrecoCD);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblR$.setBounds(89, 137, 17, 14);
		contentPane.add(lblR$);
		
		//instancia de um Controller
		ButtonsController btnController = ButtonsController.getInstance();
		btnController.setTelaCreme(this);
		//mandar ação do botão para o controller
		btnVoltar.addActionListener(btnController);
		btnCriar.addActionListener(btnController);
		btnController.setTfPreco(ftPrecoCD);
		btnController.setCbTipo(cbMarcaCreme);
	}

}

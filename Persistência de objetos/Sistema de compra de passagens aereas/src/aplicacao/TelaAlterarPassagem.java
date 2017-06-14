package aplicacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;

public class TelaAlterarPassagem extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNumero;
	private JLabel lblValor;
	private JLabel lblCpfPassageiro;
	private JLabel lblNumeroVoo;
	private JButton btnAlterar;
	
	/**
	 * Create the frame.
	 */
	public TelaAlterarPassagem() {
		setTitle("Alterar Passagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(182, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 14, 156, 14);
		contentPane.add(lblNumero);
		
		lblValor = new JLabel("Novo valor");
		lblValor.setBounds(10, 52, 156, 14);
		contentPane.add(lblValor);

		lblNumeroVoo = new JLabel("Novo Numero Voo");
		lblNumeroVoo.setBounds(10, 92, 156, 14);
		contentPane.add(lblNumeroVoo);
			
		lblCpfPassageiro = new JLabel("Novo CPF Passageiro");
		lblCpfPassageiro.setBounds(10, 132, 156, 14);
		contentPane.add(lblCpfPassageiro);
	

		textField_1 = new JTextField();
		textField_1.setBounds(182, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(182, 89, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(182, 129, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);


		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int numPassagem =  Integer.parseInt(textField.getText());
					Double valor = Double.parseDouble(textField_1.getText());
					int numVoo =  Integer.parseInt(textField_2.getText());
					int cpfPassageiro =  Integer.parseInt(textField_3.getText());
					Sistema.alterarPassagem(numPassagem, valor, numVoo, cpfPassageiro);
					JOptionPane.showMessageDialog(null,"Passagem alterada c/ sucesso ");

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnAlterar.setBounds(168, 168, 115, 23);
		contentPane.add(btnAlterar);
	}
}

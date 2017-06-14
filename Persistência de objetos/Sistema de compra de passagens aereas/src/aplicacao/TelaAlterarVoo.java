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

public class TelaAlterarVoo extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNumero;
	private JLabel lblData;
	private JButton btnAlterar;
	
	/**
	 * Create the frame.
	 */
	public TelaAlterarVoo() {
		setTitle("Alterar Voo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(82, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 14, 56, 14);
		contentPane.add(lblNumero);
		
		lblData = new JLabel("Data");
		lblData.setBounds(10, 52, 56, 14);
		contentPane.add(lblData);

		textField_1 = new JTextField();
		textField_1.setBounds(82, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);


		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					GregorianCalendar cal = new GregorianCalendar();
					
					int numero = Integer.parseInt(textField.getText());
					cal.setTime(df.parse(textField_1.getText()));
					Sistema.alterarVoo(numero, cal);
					JOptionPane.showMessageDialog(null,"Voo alterado c/ sucesso ");

					textField.setText("");
					textField_1.setText("");
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

package aplicacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;

public class TelaCadastroVoo extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNumero;
	private JLabel lblOrigem;
	private JLabel lblDestino;
	private JLabel lblData;
	private JButton btnCadastrar;
	
	/**
	 * Create the frame.
	 */
	public TelaCadastroVoo() {
		setTitle("Cadastrar Voo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(112, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 14, 66, 14);
		contentPane.add(lblNumero);

		lblOrigem = new JLabel("Origem");
		lblOrigem.setBounds(10, 52, 66, 14);
		contentPane.add(lblOrigem);
		
		lblDestino = new JLabel("Destino");
		lblDestino.setBounds(10, 92, 66, 14);
		contentPane.add(lblDestino);
		
		lblData = new JLabel("Data");
		lblData.setBounds(10, 132, 66, 14);
		contentPane.add(lblData);

		textField_1 = new JTextField();
		textField_1.setBounds(112, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 89, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 132, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					GregorianCalendar cal = new GregorianCalendar();
					
					int numero = Integer.parseInt(textField.getText());
					String origem = textField_1.getText();
					String destino = textField_2.getText();
					cal.setTime(df.parse(textField_3.getText()));
					Sistema.cadastrarVoo(numero, origem, destino, cal);
					JOptionPane.showMessageDialog(null,"Voo cadastrado c/ sucesso ");

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
		btnCadastrar.setBounds(112, 180, 115, 23);
		contentPane.add(btnCadastrar);
	}
}

package aplicacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;

public class TelaComprarPassagem extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblValor;
	private JLabel lblCpfPassageiro;
	private JLabel lblNumeroVoo;
	private JButton btnComprar;
	
	/**
	 * Create the frame.
	 */
	public TelaComprarPassagem() {
		setTitle("Comprar passagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(152, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 14, 126, 14);
		contentPane.add(lblValor);

		lblCpfPassageiro = new JLabel("CPF Passageiro");
		lblCpfPassageiro.setBounds(10, 52, 126, 14);
		contentPane.add(lblCpfPassageiro);
		
		lblNumeroVoo = new JLabel("Numero Voo");
		lblNumeroVoo.setBounds(10, 92, 126, 14);
		contentPane.add(lblNumeroVoo);

		textField_1 = new JTextField();
		textField_1.setBounds(152, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(152, 89, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Double valor = Double.parseDouble(textField.getText());
					int cpfPassageiro =  Integer.parseInt(textField_1.getText());
					int numVoo =  Integer.parseInt(textField_2.getText());
					Sistema.comprarPassagem(valor, cpfPassageiro, numVoo);
					JOptionPane.showMessageDialog(null,"Passagem comprada c/ sucesso ");

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnComprar.setBounds(168, 168, 115, 23);
		contentPane.add(btnComprar);
	}
}

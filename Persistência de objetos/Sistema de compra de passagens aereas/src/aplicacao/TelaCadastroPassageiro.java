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

public class TelaCadastroPassageiro extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JButton btnCadastrar;
	
	/**
	 * Create the frame.
	 */
	public TelaCadastroPassageiro() {
		setTitle("Cadastrar Passageiro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 56, 14);
		contentPane.add(lblNome);

		lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(10, 52, 56, 14);
		contentPane.add(lblCpf);

		textField_1 = new JTextField();
		textField_1.setBounds(72, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textField.getText();
					int cpf =  Integer.parseInt(textField_1.getText());
					Sistema.cadastrarPassageiro(nome, cpf);
					JOptionPane.showMessageDialog(null,"Passageiro cadastrado c/ sucesso ");

					textField.setText("");
					textField_1.setText("");
					textField.requestFocus();
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(168, 168, 115, 23);
		contentPane.add(btnCadastrar);
	}
}

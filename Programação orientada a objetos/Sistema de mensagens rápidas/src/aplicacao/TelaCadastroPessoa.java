package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;
import modelo.Pessoa;

public class TelaCadastroPessoa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JLabel lblAdicional;
	private JButton btnCriar;
	int selected;
	String nomeAdc;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPessoa frame = new TelaCadastroPessoa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroPessoa() {
		setTitle("Cadastrar Pessoa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 130, 350, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 52, 46, 14);
		contentPane.add(lblEmail);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 83, 46, 14);
		contentPane.add(lblSenha);

		textField_1 = new JTextField();
		textField_1.setBounds(72, 49, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(72, 80, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(180, 70, 110, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		lblAdicional = new JLabel("");
		lblAdicional.setBounds(180, 50, 75, 14);
		contentPane.add(lblAdicional);
		lblAdicional.setVisible(false);

		JComboBox<String> listaTipos = new JComboBox<String>();
		listaTipos.setEditable(true);
		listaTipos.addItem("Selecione");
		listaTipos.addItem("Aluno");
		listaTipos.addItem("Funcionário");
		listaTipos.addItem("Administrador");
		listaTipos.setEditable(false);
		listaTipos.setBounds(180, 10, 110, 20);
		contentPane.add(listaTipos);
		listaTipos.setSelectedIndex(0);



		listaTipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox listaTipos = (JComboBox) event.getSource();
				selected = listaTipos.getSelectedIndex();
				if(selected==1){
					nomeAdc = "Curso";
					lblAdicional.setText("");
					lblAdicional.setText(nomeAdc);
					lblAdicional.setVisible(true);
					textField_3.setVisible(true);

				}else if(selected==2){
					nomeAdc = "Depto";
					lblAdicional.setText("");
					lblAdicional.setText(nomeAdc);
					lblAdicional.setVisible(true);
					textField_3.setVisible(true);
				}else if(selected==3){
					nomeAdc = "Depto";
					lblAdicional.setText("");
					lblAdicional.setText(nomeAdc);
					lblAdicional.setVisible(true);
					textField_3.setVisible(true);
				}else{
					nomeAdc = "";
					lblAdicional.setVisible(false);
					textField_3.setVisible(false);
				}  
			} 
		});


		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nome = textField.getText();
					String email = textField_1.getText();
					String senha = textField_2.getText();
					String adicional = textField_3.getText();
					Pessoa p = null;
					if (selected == 1) {
						p = Sistema.cadastrarPessoa(nome, email, senha, adicional, 1);
					} else if (selected == 2) {
						p = Sistema.cadastrarPessoa(nome, email, senha, adicional, 2);
					} else if (selected == 3){
						p = Sistema.cadastrarPessoa(nome, email, senha, adicional, 3);
					}

					JOptionPane.showMessageDialog(null,"cadastrado "+p.getNome());

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
		btnCriar.setBounds(10, 115, 150, 23);
		contentPane.add(btnCriar);
	}
}

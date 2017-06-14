package aplicacao;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;
import modelo.Pessoa;
import modelo.Mensagem;

public class TelaEnviarMensagem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEmail;
	private JLabel lblTexto;
	private JTextArea textArea;
	private JButton btnCriar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEnviarMensagem frame = new TelaEnviarMensagem();
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
	public TelaEnviarMensagem() {
		setTitle("Enviar Mensagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 130, 350, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea(10,20);
		textArea.setBounds(10, 60, 320, 140);
		textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(textArea);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 10, 46, 14);
		contentPane.add(lblEmail);
		
		lblTexto = new JLabel("Texto");
		lblTexto.setBounds(10, 40, 46, 14);
		contentPane.add(lblTexto);


		btnCriar = new JButton("Enviar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String email = textField.getText();
					String mensagem = textArea.getText();
				
					Mensagem msg = Sistema.enviarMensagem(email, mensagem);
					JOptionPane.showMessageDialog(null,"Mensagem enviada! id: "+msg.getId());

					textField.setText("");
					textField.requestFocus();
					textArea.setText("");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(10, 210, 150, 23);
		contentPane.add(btnCriar);
	}
}

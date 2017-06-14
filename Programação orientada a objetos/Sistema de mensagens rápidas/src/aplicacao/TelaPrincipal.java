package aplicacao;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;
import modelo.Administrador;
import modelo.Mensagem;
import modelo.Pessoa;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmListar;
	private JMenu menuPessoa;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JPanel contentPane;
	private JButton btnLogar;
	private JButton btnLogoff;
	private JLabel titulo;
	private JLabel subtitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//------ PRE CADASTRAMENTO
		
		try {	
			// dados criados para teste
			Pessoa p1, p2, p3, p4, p5;//cadastro de 4 pessoas
			p1 = Sistema.cadastrarPessoa("Jose", "jose@gmail.com", "123", "Sistemas", 1);
			p2 = Sistema.cadastrarPessoa("Maria", "maria@gmail.com", "123", "Redes", 1);
			p3 = Sistema.cadastrarPessoa("Joana", "joana@gmail.com", "123", "DP1", 2);
			p4 = Sistema.cadastrarPessoa("Marcelo", "marcelo@gmail.com", "123", "DP2", 2);
			p5 = Sistema.cadastrarPessoa("admin", "admin@ifpb.com", "007", "DTI", 3);

			Pessoa pjose = Sistema.login("jose@gmail.com", "123");
			Mensagem m1 = Sistema.enviarMensagem("maria@gmail.com", "Ola maria, tudo bem?");
			Sistema.logoff();

			Pessoa pmaria = Sistema.login("maria@gmail.com", "123");
			Mensagem m2 = Sistema.enviarMensagem("jose@gmail.com", "Ola jose, estou bem e voce?");
			Mensagem m3 = Sistema.enviarMensagem("joana@gmail.com", "Lorem ipsum dolor sit amet,"
					+ " consectetur adipiscing elit. Donec at egestas mauris. Nam eget congue felis.");
			Sistema.logoff();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//------
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("SMR - Sistema de mensagens");
		frmPrincipal.setBounds(400, 100, 600, 350);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmPrincipal.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mostrarMenu();
		

		titulo = new JLabel("Bem vindo ao SMR - Sistema de Mensagens Rápidas");
		titulo.setBounds(120, 10, 400, 30);
		titulo.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(titulo);
		
		subtitulo = new JLabel("Faça login para continuar");
		subtitulo.setBounds(210, 45, 400, 30);
		subtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(subtitulo);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(220, 100, 46, 14);
		contentPane.add(lblEmail);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(220, 130, 46, 14);
		contentPane.add(lblSenha);

		textField = new JTextField();
		textField.setBounds(280, 100, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(280, 130, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String email = textField.getText();
					String senha = textField_1.getText();
					if (!Sistema.temLogado()) {
						Pessoa pt = Sistema.login(email, senha);
						JOptionPane.showMessageDialog(null,"Bem vindo(a), "+pt.getNome());
						
						textField.setText("");
						textField.requestFocus();
						textField_1.setText("");
						
						frmPrincipal.setTitle("SMR - Sistema de mensagens - Logado: "+pt.getNome());
					} else {
						JOptionPane.showMessageDialog(null,"Faca logoff para logar novamente");
					}							
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnLogar.setBounds(218, 170, 150, 23);
		contentPane.add(btnLogar);
		
		//-----------
		
		btnLogoff = new JButton("Logoff");
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Sistema.logoff();
					
					textField.setText("");
					textField.requestFocus();
					textField_1.setText("");
					JOptionPane.showMessageDialog(null,"Logoff realizado com sucesso");
					frmPrincipal.setTitle("SMR - Sistema de mensagens");
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnLogoff.setBounds(218, 200, 150, 23);
		contentPane.add(btnLogoff);
		
	}
	
	public void mostrarMenu() {

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);
		
		menuPessoa = new JMenu("Pessoa");
		menuBar.add(menuPessoa);
		
		mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					TelaCadastroPessoa j = new TelaCadastroPessoa();
					j.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
				
			}
		});
		menuPessoa.add(mntmCadastrar);
		
		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					TelaListagemPessoa j = new TelaListagemPessoa();
					j.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuPessoa.add(mntmListar);
		
		JMenu menuMensagem = new JMenu("Mensagem");
		menuBar.add(menuMensagem);
		
		JMenuItem mntmEnviar = new JMenuItem("Enviar");
		mntmEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					TelaEnviarMensagem j = new TelaEnviarMensagem();
					j.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuMensagem.add(mntmEnviar);
		
		JMenuItem mntmListarEntrada = new JMenuItem("Listar Entrada");
		mntmListarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					TelaListagemEntrada j = new TelaListagemEntrada();
					j.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuMensagem.add(mntmListarEntrada);
		
		JMenuItem mntmListarSaida = new JMenuItem("Listar Saida");
		mntmListarSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					TelaListagemSaida j = new TelaListagemSaida();
					j.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuMensagem.add(mntmListarSaida);
		
		JMenuItem mntmLer = new JMenuItem("Ler");
		mntmLer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					TelaLerMensagem j = new TelaLerMensagem();
					j.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuMensagem.add(mntmLer);
		
		JMenuItem mntmTotal = new JMenuItem("Total nao lidas");
		mntmTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					try {
						int i = Sistema.totalMensagensNaoLidas();
						JOptionPane.showMessageDialog(null,"Voce possui ["+i+"] mensagens nao lidas");
					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null,erro.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuMensagem.add(mntmTotal);

		JMenuItem mntmApagar = new JMenuItem("Apagar");
		mntmApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					try {
						String s = JOptionPane.showInputDialog(null,"Insira o id para apagar: ");
						int i = Integer.parseInt(s);
						Sistema.apagarMensagem((i));
						JOptionPane.showMessageDialog(null,"Mensagem "+i+" apagada com suceso!");
					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null,erro.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuMensagem.add(mntmApagar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Sistema.temLogado()) {
					Pessoa p = Sistema.getPlogada();
					if (p instanceof Administrador) {
						TelaConsultar j = new TelaConsultar();
						j.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"Apenas o administrador tem acesso a essa opcao");
					}
					
				} else {
					JOptionPane.showMessageDialog(null,"Logue para acessar essa opcao");
				}
			}
		});
		menuMensagem.add(mntmConsultar);
	}

}

package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Sistema;

public class TelaPrincipal {
	private JFrame frmPrincipal;

	private JMenu mnPassageiro;
	private JMenuItem mntmPassageiro;
	private JMenuItem mntmExcluirPassageiro;
	
	private JMenu mnVoo;
	private JMenuItem mntmVoo;
	private JMenuItem mntmCancelarVoo;
	private JMenuItem mntmAlterarVoo;
	
	private JMenu mnPassagem;
	private JMenuItem mntmComprar;
	private JMenuItem mntmPassagens;
	private JMenuItem mntmAlterarPassagem;
	private JMenuItem mntmCancelarPassagem;
	
	private JMenu mnExtra;
	private JMenuItem mntmConsultas;

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
		frmPrincipal = new JFrame();

		try {
			frmPrincipal.setContentPane(new Fundo("aviao.png"));
		} catch (IOException e1) {
		}	

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Sistema.inicializar();
				JOptionPane.showMessageDialog(null, "sistema inicializado !");

			}
			@Override
			public void windowClosing(WindowEvent e) {
				Sistema.finalizar();
				JOptionPane.showMessageDialog(null, "sistema finalizado !");

			}
		});
		frmPrincipal.setTitle("Sistema de Compra de Passagens");
		frmPrincipal.setBounds(100, 100, 436, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);

		//----------- passageiro -----------------
		mnPassageiro = new JMenu("Passageiro");
		menuBar.add(mnPassageiro);
		//cadastrar
		mntmPassageiro = new JMenuItem("Cadastrar");
		mntmPassageiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroPassageiro telaP = new TelaCadastroPassageiro();
				telaP.setVisible(true);
			}
		});
		mnPassageiro.add(mntmPassageiro);
		//listar
		JMenuItem mntmPassageiros = new JMenuItem("Listar");
		mnPassageiro.add(mntmPassageiros);
		mntmPassageiros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarPassageiros telaLP = new TelaListarPassageiros();
				telaLP.setVisible(true);
			}
		});
		//excluir
		mntmExcluirPassageiro = new JMenuItem("Excluir");
		mnPassageiro.add(mntmExcluirPassageiro);
		mntmExcluirPassageiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = JOptionPane.showInputDialog("cpf");
				try {
					Sistema.excluirPassageiro(Integer.parseInt(cpf));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"cpf invalido");
				}
			}
		});
		//------------------------ fim
		
		///------- voo ---------------------
		mnVoo = new JMenu("Vôo");
		menuBar.add(mnVoo);
		//cadastrar
		mntmVoo = new JMenuItem("Cadastrar");
		mntmVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroVoo telaV = new TelaCadastroVoo();
				telaV.setVisible(true);
			}
		});
		mnVoo.add(mntmVoo);
		//listar
		JMenuItem mntmVoos = new JMenuItem("Listar");
		mnVoo.add(mntmVoos);
		mntmVoos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarVoos telaLV = new TelaListarVoos();
				telaLV.setVisible(true);
			}
		});
		//alterar
		mntmAlterarVoo = new JMenuItem("Alterar");
		mntmAlterarVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlterarVoo telaAV = new TelaAlterarVoo();
				telaAV.setVisible(true);
			}
		});
		mnVoo.add(mntmAlterarVoo);
		//excluir
		mntmCancelarVoo = new JMenuItem("Excluir");
		mnVoo.add(mntmCancelarVoo);
		mntmCancelarVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = JOptionPane.showInputDialog("numero");
				try {
					Sistema.cancelarVoo(Integer.parseInt(num));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"numero invalido");
				}
			}
		});
		//------------------- fim
		
		//----- Passagem ---------------------
		mnPassagem = new JMenu("Passagem");
		menuBar.add(mnPassagem);
		//cadastrar
		mntmComprar = new JMenuItem("Comprar");
		mntmComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaComprarPassagem telaPS = new TelaComprarPassagem();
				telaPS.setVisible(true);
			}
		});
		mnPassagem.add(mntmComprar);
		//listar
		JMenuItem mntmPassagens = new JMenuItem("Listar");
		mnPassagem.add(mntmPassagens);
		mntmPassagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarPassagens telaLPS = new TelaListarPassagens();
				telaLPS.setVisible(true);
			}
		});
		//alterar
		mntmAlterarPassagem = new JMenuItem("Alterar");
		mntmAlterarPassagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAlterarPassagem telaAPS = new TelaAlterarPassagem();
				telaAPS.setVisible(true);
			}
		});
		mnPassagem.add(mntmAlterarPassagem);
		//excluir
		mntmCancelarPassagem = new JMenuItem("Excluir");
		mnPassagem.add(mntmCancelarPassagem);
		mntmCancelarPassagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = JOptionPane.showInputDialog("numero");
				try {
					Sistema.cancelarPassagem(Integer.parseInt(num));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"numero invalido");
				}
			}
		});
		//------------------ fim
		
		//----- Consultas ---------------------
				mnExtra = new JMenu("Extra");
				menuBar.add(mnExtra);
			
				//listar
				JMenuItem mntmConsultas = new JMenuItem("Consultas");
				mnExtra.add(mntmConsultas);
				mntmConsultas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaConsultas telaCons = new TelaConsultas();
						telaCons.setVisible(true);
					}
				});
				//------------------ fim
		
		
	}
}

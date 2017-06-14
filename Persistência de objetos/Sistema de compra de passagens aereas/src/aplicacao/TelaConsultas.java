package aplicacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Sistema;

public class TelaConsultas extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JScrollPane scroller;
	private JButton btnPoltronaPassageiro;
	private JButton btnPassageirosdeVoo;
	private JButton btnVoosCidade;
	private JButton btnVagasemVoo;
	private JButton btnPassageiroSemVoo;
	private JButton btnLimpar;
	
	/**
	 * Create the frame.
	 */
	public TelaConsultas() {
		setTitle("Listar Passagens");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scroller = new JScrollPane(textArea);
		scroller.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroller.setBounds(24, 29, 450, 282);
		contentPane.add(scroller);
		
		
		btnPassageirosdeVoo = new JButton("Passageiros de Voo");
		btnPassageirosdeVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String num = JOptionPane.showInputDialog("numero voo");
					textArea.setText(Sistema.consultarPassageirosdoVoo(Integer.parseInt(num)));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}			

			}
		});
		btnPassageirosdeVoo.setBounds(140, 338, 220, 23);
		contentPane.add(btnPassageirosdeVoo);
		
		btnVoosCidade = new JButton("Voos p/ cidade");
		btnVoosCidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String cidade = JOptionPane.showInputDialog("cidade");
					textArea.setText(Sistema.consultarVoosparaCidade(cidade));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}			

			}
		});
		btnVoosCidade.setBounds(140, 378, 220, 23);
		contentPane.add(btnVoosCidade);
		
		btnVagasemVoo = new JButton("Vagas em Voo");
		btnVagasemVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String num = JOptionPane.showInputDialog("numero voo");
					textArea.setText(Sistema.consultarVagasemVoo(Integer.parseInt(num)));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}			

			}
		});
		btnVagasemVoo.setBounds(140, 418, 220, 23);
		contentPane.add(btnVagasemVoo);
		
		btnPassageiroSemVoo = new JButton("Passageiros s/ Voo");
		btnPassageiroSemVoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					textArea.setText(Sistema.consultarPassageirosSemVoo());
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}			

			}
		});
		btnPassageiroSemVoo.setBounds(140, 458, 220, 23);
		contentPane.add(btnPassageiroSemVoo);
		
		btnLimpar = new JButton("Limpar tela");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnLimpar.setBounds(140, 498, 220, 23);
		contentPane.add(btnLimpar);

	}
}

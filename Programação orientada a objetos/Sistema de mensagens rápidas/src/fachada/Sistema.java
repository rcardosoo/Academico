package fachada;

import modelo.SMR;
import modelo.Pessoa;
import modelo.Administrador;
import modelo.Aluno;
import modelo.Funcionario;
import modelo.Mensagem;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {
	private static SMR smr = new SMR();
	private static Pessoa plogada;

	public static Pessoa login (String email, String senha) throws Exception {
		//valida a pessoa no SMR, que passa a ser logada
		Pessoa temp = smr.localizarPessoa(email);
		if (temp != null) {
			//Existe uma pessoa com o email enviado no parametro:
			if (senha.equals(temp.getSenha())) {
				//email e senha corretos
				plogada = temp;
				return plogada;
			} else {
				throw new Exception("Email e senha nao correspondem");
			}
		}
		throw new Exception("Pessoa nao cadastrada!");

	}//Retorna a pessoa logada ou null

	public static void logoff() throws Exception{
		// a pessoa deixa de ser logada
		plogada = null;
	}

	public static Pessoa cadastrarPessoa (String nome, String email, String senha, String adicional, int ident) throws Exception{
		//cadastra uma pessoa no SMR
		Pessoa aux = smr.localizarPessoa(email);
		if (aux == null) {
			Pessoa p;
			if (ident == 1) {//os dados informados sao de um aluno
				p = new Aluno(nome, email, senha);//Uma objeto aluno eh instanciado
				((Aluno) p).setCurso(adicional);
			} else {//os dados informados sao de um funcionario
				if (ident == 2) {
					p = new Funcionario(nome, email, senha);//Uma objeto funcionario eh instanciado
					((Funcionario) p).setDepartamento(adicional);
				} else {
					p = new Administrador(nome, email, senha);//Uma objeto funcionario eh instanciado
					((Administrador) p).setDepartamento(adicional);
				}
			}
			smr.adicionarPessoa(p);//adiciona pessoa ao smr
			return p;
		} else {
			throw new Exception("Pessoa ja cadastrada!");
		}

	}

	public static String listarPessoas (String nome) {
		//lista pessoas do SMR, contendo ou nao o nome
		ArrayList<Pessoa> aux = smr.getPessoas();
		int flag = 0;
		String texto = "";
		Collections.sort(aux);
		if (aux.isEmpty()) {
			texto += "nao tem pessoas\n";
			return texto;
		} else {
			for(Pessoa p : aux) {
				if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
					flag = 1; //Se flag for 1, existe ao menos uma pessoa com o nome informado
					texto +=  p + "\n";
				}
			}
			if (flag == 0) {//Se flag for 0, nao existe ninguem com o nome informado
				//Listar todos
				for (Pessoa p : aux) {
					texto += p + "\n";
				}
			} 

			return texto;
		}
	}

	public static Mensagem enviarMensagem (String email,  String texto) throws Exception{
		//cadastra mensagem no SMR, onde o emitente eh a pessoa logada.
		Pessoa p;
		p = smr.localizarPessoa(email);
		String emaillogada = plogada.getEmail();
		if (p != null && !emaillogada.equals(email)) {
			Date data = new Date(System.currentTimeMillis());  
			SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
			//pega data corrente do sistema

			int id = smr.incrementoMsg();//incrementa o id da mensagem

			Mensagem m = new Mensagem(id, texto, formatarDate.format(data), false);
			m.setEmitente(plogada);//emitente pessoa logada
			m.setDestinatario(p);//destinatario pessoa informada no parametro
			plogada.adicionarMsSaida(m);//plogada recebe como mensagem de saida
			p.adicionarMsEntrada(m);//p recebe como mensagem de entrada
			smr.adicionarMensagem(m);

			return m;
		} else {
			throw new Exception("Destinatario inexistente ou mensagem para si mesmo!");
		}
	}

	public static String listarMensagensEntrada () throws Exception{
		// lista mensagens da pessoa logada
		ArrayList<Mensagem> aux = plogada.getMensagensEntrada();
		String texto="";

		if (aux.isEmpty()) {
			throw new Exception("Nao tem mensagens");
		} else {
			String auxTexto;
			for(Mensagem m: aux) {
				if (m.getTexto().length() < 31) {//se o texto tiver menos que 30 caracteres..
					auxTexto = m.getTexto();//mostra o texto inteiro
				} else {//senao
					auxTexto = m.getTexto().substring(0,31) +"...";//mostra ate 30 caracteres do texto
				}
				texto +=  "\nId: " + m.getId() + " - Emitente: "+ m.getEmitente().getEmail() +""
						+ " - Data: "+ m.getData() +"\nTexto: "+ auxTexto +"\n---------------------------------"; 
			}
			return texto;
		}
	}

	public static String listarMensagensSaida () throws Exception{{
		// lista mensagens da pessoa logada
		ArrayList<Mensagem> aux = plogada.getMensagensSaida();
		String texto="";
		if (aux.isEmpty()) {
			throw new Exception("Nao tem mensagens");
		} else {
			String auxTexto;
			for(Mensagem m: aux) {
				if (m.getTexto().length() < 31) {//se o texto tiver menos que 30 caracteres..
					auxTexto = m.getTexto();//mostra o texto inteiro
				} else {//senao
					auxTexto = m.getTexto().substring(0,31) +"...";//mostra ate 30 caracteres do texto
				}
				texto +=  "\nId: " + m.getId() + " - Destinatario: "+ m.getDestinatario().getEmail() +""
						+ " - Data: "+ m.getData() +"\nTexto: "+ auxTexto +"\n---------------------------------"; 
			}
			return texto;
		}
	}
	}

	public static Mensagem lerMensagem(int id) throws Exception{
		// obtem uma das mensagens da pessoa logada
		Mensagem m = plogada.localizarMsEntrada(id);
		if (m != null) {
			m.setLida(true);
			return m;
		} else {
			throw new Exception("Mensagem nao existe");
		}
	}

	public static int totalMensagensNaoLidas () throws Exception {
		// obtem o total de mensagens nao lidas da pessoa logada
		ArrayList<Mensagem> aux = plogada.getMensagensEntrada();
		int total=0;
		for (Mensagem m : aux) {
			if (!m.isLida()) {
				total++;
			}
		}
		return total;
	}

	public static void apagarMensagem(int id) throws Exception{
		// obtem uma das mensagens da pessoa logada
		Mensagem m = plogada.localizarMsEntrada(id);
		if (m != null) {
			plogada.removerMsEntrada(m);
		} else {
			m = plogada.localizarMsSaida(id);
			if (m != null) {
				plogada.removerMsSaida(m);
			} else {
				throw new Exception("Mensagem nao existe na caixa de entrada ou saida!");
			}
		}
	}

	public static String buscarMensagem (String busca) throws Exception {
		//lista pessoas do SMR, contendo ou nao o nome
		if (plogada instanceof Administrador) {
			ArrayList<Mensagem> aux = smr.getMensagens();
			int flag = 0;
			String texto = "\nMensagens: \n\n";

			if (aux.isEmpty()) {
				throw new Exception("Nao tem mensagens");
			} else {
				for(Mensagem m : aux) {
					if (m.getTexto().toLowerCase().contains(busca.toLowerCase())) {
						flag = 1; //Se flag for 1, existe ao menos uma pessoa com o nome informado
						texto +=  m.getId() + " - "+ m.getTexto() +"\n------------------------------\n\n";
					}
				}
				if (flag == 0) {//Se flag for 0, nao existe ninguem com o nome informado
					//Listar todos
					for (Mensagem m : aux) {
						texto +=  m.getId() + " - "+ m.getTexto() +"\n------------------------------\n\n";
					}
				} 

				return texto;
			}
		} else {
			throw new Exception("Apenas o administrador pode consultar mensagens!");
		}
	}

	public static boolean temLogado() {//metodo para saber se existe alguem logado
		return plogada != null;
	}

	public static Pessoa getPlogada() {
		return plogada;
	}
}

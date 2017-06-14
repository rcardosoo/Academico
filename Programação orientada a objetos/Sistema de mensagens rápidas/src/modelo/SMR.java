package modelo;

import java.util.ArrayList;

public class SMR {
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa> ();
	private ArrayList<Mensagem> mensagens = new ArrayList<Mensagem> ();
	
	public SMR() {
		super();
	}
	
	public void adicionarMensagem (Mensagem m) {
		mensagens.add(m);
	}

	public void removerMensagem (Mensagem m) {
		mensagens.remove(m);
	}

	public Mensagem localizarMensagem (int id) {
		for(Mensagem m : mensagens){
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	
	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}
	
	public void setMensagens(ArrayList<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	public void adicionarPessoa (Pessoa p) {
		pessoas.add(p);
	}

	public void removerPessoa (Pessoa p) {
		pessoas.remove(p);
	}

	public Pessoa localizarPessoa (String email) {
		for(Pessoa p : pessoas){
			if(p.getEmail().equals(email))
				return p;
		}
		return null;
	}
	
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public int incrementoMsg() {
		return mensagens.size()+1;
	}
	
}

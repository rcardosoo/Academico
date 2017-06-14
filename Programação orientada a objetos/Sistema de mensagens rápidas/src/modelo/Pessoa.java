package modelo;

import java.util.ArrayList;

public abstract class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Mensagem> caixaEntrada = new ArrayList<Mensagem> ();
	private ArrayList<Mensagem> caixaSaida = new ArrayList<Mensagem> ();

	public Pessoa(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ArrayList<Mensagem> getMensagensEntrada() {
		return caixaEntrada;
	}

	public void setMensagensEntrada(ArrayList<Mensagem> caixaEntrada) {
		this.caixaEntrada = caixaEntrada;
	}
	
	public ArrayList<Mensagem> getMensagensSaida() {
		return caixaSaida;
	}

	public void setMensagensSaida(ArrayList<Mensagem> caixaSaida) {
		this.caixaSaida = caixaSaida;
	}

	//------------------------------


	public void adicionarMsEntrada (Mensagem m) {
		caixaEntrada.add(m);
	}

	public void removerMsEntrada (Mensagem m) {
		caixaEntrada.remove(m);
	}

	public Mensagem localizarMsEntrada (int id) {
		for(Mensagem m : caixaEntrada){
			if(m.getId() == id)
				return m;
		}
		return null;
	}

	public int getTotalMsEntrada () {
		return caixaEntrada.size();
	}

	public void adicionarMsSaida (Mensagem m) {
		caixaSaida.add(m);
	}

	public void removerMsSaida (Mensagem m) {
		caixaSaida.remove(m);
	}

	public Mensagem localizarMsSaida (int id) {
		for(Mensagem m : caixaSaida){
			if(m.getId() == id)
				return m;
		}
		return null;
	}

	public int getTotalMsSaida () {
		return caixaSaida.size();
	}

	@Override
	public String toString() {
		String texto = "Pessoa [nome=" + nome + ", "
				+ "email=" + email + ","
				+ " senha=" + senha + "]\n";
		return texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public int compareTo(Pessoa p) {
		return this.nome.compareTo(p.getNome());
	}
}
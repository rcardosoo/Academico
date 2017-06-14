package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Passageiro {
	@Id
	private int cpf;
	private String nome;
	@OneToMany(mappedBy="passageiro", cascade=CascadeType.ALL)
	private List<Passagem> passagens = new ArrayList<Passagem>();
	
	
	public Passageiro() {}
	public Passageiro(String nome, int cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	//passagens ------------------
	public List<Passagem> getPassagens() {
		return passagens;
	}

	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
	}
	
	public void addPassagem(Passagem p){
		passagens.add(p);
		p.setPassageiro(this);
	}
	
	public void removerPassagem(Passagem p){
		passagens.remove(p);
		p.setPassageiro(null);
	}
	
	public Passagem localizarPassagem(int numero){
		for(Passagem p : passagens){
			if(p.getNumPassagem() == numero)
				return p;
		}
		return null;
	}
	//fim --------------------------
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		String texto = "Passageiro [nome=" + nome + ", cpf=" + cpf;
		
		texto += "\n  lista de passagens: ";
		if (passagens.isEmpty())
			texto += "sem passagens";
		else 	
			for(Passagem p: passagens) 
				texto += "\n  --> Numero=" + p.getNumPassagem();
		
		return texto+="]";
	}
	
}

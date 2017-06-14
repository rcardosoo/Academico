package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

@Entity
public class Voo {
	@Id
	private int numero;
	private String origem;
	private String destino;
	@Temporal(TemporalType.DATE)
	private Date dataViagem;
	@OneToMany(mappedBy="voo", cascade=CascadeType.ALL)
	private List<Passagem> passagens = new ArrayList<Passagem>();
	@OneToMany(mappedBy="voo", cascade=CascadeType.ALL)
	private List<Poltrona> poltronas = new ArrayList<Poltrona>();
	
	public Voo (){}
	public Voo(int numero, String origem, String destino, GregorianCalendar dataViagem) {
		super();
		this.numero = numero;
		this.origem = origem;
		this.destino = destino;
		this.dataViagem = dataViagem.getTime();
	}
	

	public List<Passagem> getPassagens() {
		return passagens;
	}



	public void setPassagens(List<Passagem> passagens) {
		this.passagens = passagens;
	}



	public List<Poltrona> getPoltronas() {
		return poltronas;
	}



	public void setPoltronas(List<Poltrona> poltronas) {
		this.poltronas = poltronas;
	}



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Date getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(GregorianCalendar dataViagem) {
		this.dataViagem = dataViagem.getTime();
	}
	
	public void addPassagem(Passagem p){
		passagens.add(p);
		p.setVoo(this);
	}
	
	public void removerPassagem(Passagem p){
		passagens.remove(p);
		p.setVoo(null);
	}
	
	public Passagem localizarPassagem(int numero){
		for(Passagem p : passagens){
			if(p.getNumPassagem() == numero)
				return p;
		}
		return null;
	}
	
	public void addPoltrona(Poltrona p){
		poltronas.add(p);
		p.setVoo(this);
	}
	
	public void removerPoltrona(Poltrona p){
		poltronas.remove(p);
		p.setVoo(null);
	}
	
	public Poltrona localizarPoltrona(int numero){
		for(Poltrona p : poltronas){
			if(p.getNumPoltrona() == numero)
				return p;
		}
		return null;
	}
	
	public int getTotalPassagens() {
		return passagens.size();
	}
	
	public int getPoltronaVazia() {
		for (Poltrona p : poltronas) {
			if (!p.isOcupacao())
				return p.getNumPoltrona();
		}
		return -1;
	}
	
	
	@Override
	public String toString() {
		String texto = "Voo [numero=" + numero + ", origem=" + origem + ", destino=" + destino + ", dataViagem=" + dataViagem
				+ "]";
		texto += "\n  lista de poltronas: ";
		if (poltronas.isEmpty())
			texto += "sem poltrona";
		else 	
			for(Poltrona p: poltronas){
				texto += "\n  --> Numero=" + p.getNumPoltrona();
				if (p.isOcupacao())
					texto += ", ocupada";
				else
					texto += ", livre";
			} 
		
		texto += "\n  lista de passagens: ";
		if (passagens.isEmpty())
			texto += "sem passagens";
		else 	
			for(Passagem p: passagens) 
				texto += "\n  --> Numero=" + p.getNumPassagem();

		return texto + "\n]";
	}

}

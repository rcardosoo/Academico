package modelo;

import javax.persistence.*;

@Entity
public class Poltrona {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numPoltrona;
	@OneToOne
	private Passageiro passageiro;
	@ManyToOne
	private Voo voo;
	private boolean ocupacao = false;
	
	public Poltrona() {}
	public Poltrona(Passageiro passageiro, boolean ocupacao) {
		super();
		this.numPoltrona = numPoltrona;
		this.passageiro = passageiro;
		this.ocupacao = ocupacao;
	}

	public boolean isOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(boolean ocupacao) {
		this.ocupacao = ocupacao;
	}

	
	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public int getNumPoltrona() {
		return numPoltrona;
	}

	public void setNumPoltrona(int numPoltrona) {
		this.numPoltrona = numPoltrona;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	@Override
	public String toString() {
		String texto = "Poltrona [numPoltrona=" + numPoltrona + ", passageiro=";
		if (passageiro != null)
			texto += passageiro.getNome();
		else
			texto += "sem passageiro";
		
		if (voo != null)
			texto += ", Voo= "+voo.getNumero();
		else
			texto += ", sem voo";
		
		texto += ", ocupacao=";
		if (this.isOcupacao())
			texto += " ocupada";
		else
			texto += " livre";
		texto += "]";
		return texto;
	}
	
	
}

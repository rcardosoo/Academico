package modelo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Passagem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numPassagem;
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	private double valor;
	@ManyToOne
	private Passageiro passageiro;
	@ManyToOne
	private Voo voo;
	
	public Passagem() {}
	public Passagem(double valor, Passageiro passageiro, Voo voo){
		super();
		this.dataCompra = new Date(System.currentTimeMillis());
		this.valor = valor;
		this.passageiro = passageiro;
		this.voo = voo;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public int getNumPassagem() {
		return numPassagem;
	}

	public void setNumPassagem(int numPassagem) {
		this.numPassagem = numPassagem;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	@Override
	public String toString() {
		String texto = "Passagem [numPassagem=" + numPassagem + ", dataCompra=" + dataCompra + ", valor=" + valor
				+ ", passageiro=";
		
		if (passageiro == null) {
			texto += " sem passageiro";
		} else {
			texto += " "+passageiro.getNome();
		}
		
		texto += ", voo=";
		
		if (voo == null) {
			texto += " sem voo";
		} else {
			texto += " "+ voo.getNumero() + "]";
		}
		return texto;
	}


			
	
}

package classes;

import java.util.ArrayList;
import java.util.List;

import classes.distribuicao.Distribuicao;

public class Jogo {
	private Baralho b;
	private Distribuicao algoritmo;
	private int rodada;
	private Jogador jogador1;
	private Jogador jogador2;
	
	public Jogo() {
		super();
		this.rodada = 1;
	}

	
	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public Baralho getB() {
		return b;
	}

	public void setB(Baralho b) {
		this.b = b;
	}

	public Distribuicao getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(Distribuicao algoritmo) {
		this.algoritmo = algoritmo;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}
	

	public void distribuir() {
		Baralho b = this.getB();
		b.embaralhar();
		List<Carta> c = new ArrayList<Carta>();
		
		Distribuicao d = this.getAlgoritmo();
		System.out.println("..Distribuindo cartas");
		c = d.distribuir(b);
		
		this.getJogador1().setCarta(c.get(0));
		this.getJogador2().setCarta(c.get(1));
	}

	
	public boolean checar() {//retorna false quando o jogo acaba e true quando iterou a rodada
		Jogador j1 = this.getJogador1();
		Jogador j2 = this.getJogador2();
		Jogador ganhou; //vencedor da RODADA
		
		System.out.println("A carta de "+j1.getNome()+" eh "+j1.getCarta().getNumero()+" de "+j1.getCarta().getNaipe());
		System.out.println("A carta de "+j2.getNome()+" eh "+j2.getCarta().getNumero()+" de "+j2.getCarta().getNaipe());
		
		//verificar carta vencedora
		if (j1.getCarta().getNumero() > j2.getCarta().getNumero()) {
			//j1 vence
			j1.setPontos(j1.getPontos()+10);
			ganhou = j1;
			
		} else if (j1.getCarta().getNumero() < j2.getCarta().getNumero()) {
			//j2 vence
			j2.setPontos(j2.getPontos()+10);
			ganhou = j2;
		} else {
			//empate
			j1.setPontos(j1.getPontos()+10);
			j2.setPontos(j2.getPontos()+10);
			ganhou = null;
		}
		
		if (this.getRodada() < 10) {//da 1 a 9 rodada, vai atribuindo os pontos e passando...
			//itera rodada
			this.setRodada(this.getRodada()+1);
			if (ganhou != null) {
				System.out.println(ganhou.getNome()+" ganhou a rodada, vamos a proxima!");
			}
			else
				System.out.println("A rodada empatou, os dois recebem pontos, vamos a proxima!");
			return true;
			
		} else if (this.getRodada() == 10){//se for a 10 rodada, verifica quem ganhou
			Jogador j = this.mostraVencedor(j1, j2);
			if (j != null) {
				System.out.println("O jogador "+j.getNome()+" VENCEU O JOGO!!!");
				return false;
			} else {
				System.out.println("O jogo está empatado, vamos a proxima rodada!!");
				this.setRodada(this.getRodada()+1);
				return true;
			}
			
		} else {//a partir da 10, itera e verifica a cada rodada
			System.out.println(ganhou.getNome()+" ganhou a rodada!");
			Jogador j = this.mostraVencedor(j1, j2);
			if (j != null) {
				System.out.println("O jogador "+j.getNome()+" VENCEU O JOGO!!!");
				return false;
			} else {
				System.out.println("O jogo continua empatado, vamos a proxima rodada!!");
				this.setRodada(this.getRodada()+1);
				return true;
			}
		}
					
	}
	
	public Jogador mostraVencedor(Jogador j1, Jogador j2) {
		if (j1.getPontos() > j2.getPontos()) {
			//j1 venceu o jogo
			return j1;
		} else if (j2.getPontos() > j1.getPontos()) {
			//j2 venceu o jogo
			return j2;
		} else {
			//empatou
			return null;
		}
	}
	
}

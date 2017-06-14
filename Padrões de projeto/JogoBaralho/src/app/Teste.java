package app;

import classes.Baralho;
import classes.Jogador;
import sistema.sistema;
import classes.Carta;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//jogadores
		Jogador j1 = new Jogador("Joao");
		Jogador j2 = new Jogador("Maria");
		
		System.out.println("Jogo iniciado com "+j1.getNome()+" vs "+j2.getNome());
		System.out.println("========================================");
		
		//baralho
		Baralho b = new Baralho();
		b.adicionarCarta(new Carta(2,"espada"));
		b.adicionarCarta(new Carta(3,"copas"));
		b.adicionarCarta(new Carta(5,"ouro"));
		b.adicionarCarta(new Carta(4,"ouro"));
		b.adicionarCarta(new Carta(6,"espada"));
		b.adicionarCarta(new Carta(7,"paus"));
	
		//iniciar jogo
		int modo = 3;
		sistema.jogar(modo, j1, j2, b);
		
	}

}
